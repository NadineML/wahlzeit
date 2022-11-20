package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    @Override
    public boolean equals(Object object) {
        return isEqual(object);
    }

    @Override
    public boolean isEqual(Coordinate coordinate){
        return isEqual(coordinate);
    }

    public boolean isEqual(Object object) {
        if(object == null || object.getClass() != CartesianCoordinate.class && object.getClass() != SphericCoordinate.class) {
            return false;
        }
        CartesianCoordinate c = null;
        if(object.getClass() == CartesianCoordinate.class){
            c = (CartesianCoordinate) object;
        }else{
            c = ((SphericCoordinate) object).asCartesianCoordinate();
        }
        return (this.asCartesianCoordinate().getX() == c.getX() && this.asCartesianCoordinate().getY() == c.getY() && this.asCartesianCoordinate().getZ() == c.getZ());
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();
        double deltaTheta = Math.abs(this.asSphericCoordinate().getTheta() - sphericCoord.getTheta());
        return Math.acos(
            Math.cos(this.asSphericCoordinate().getPhi()) * Math.cos(sphericCoord.getPhi()) * Math.cos(deltaTheta)
        );
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate comp = coordinate.asCartesianCoordinate();
        double x_dist = Math.pow(this.asCartesianCoordinate().getX() - comp.getX(), 2);
        double y_dist = Math.pow(this.asCartesianCoordinate().getY() - comp.getY(), 2);
        double z_dist = Math.pow(this.asCartesianCoordinate().getZ() - comp.getZ(), 2);
        return Math.sqrt(x_dist + y_dist + z_dist);
    }
}
