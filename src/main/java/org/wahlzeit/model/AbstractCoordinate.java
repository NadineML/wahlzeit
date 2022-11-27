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
        this.assertClassInvariants();
        CartesianCoordinate c = null;
        if(object.getClass() == CartesianCoordinate.class){
            c = (CartesianCoordinate) object;
        }else{
            c = ((SphericCoordinate) object).asCartesianCoordinate();
        }
        c.assertClassInvariants();
        return (this.asCartesianCoordinate().getX() == c.getX() && this.asCartesianCoordinate().getY() == c.getY() && this.asCartesianCoordinate().getZ() == c.getZ());
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        this.assertClassInvariants();
        SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();
        sphericCoord.assertClassInvariants();
        double deltaTheta = Math.abs(this.asSphericCoordinate().getTheta() - sphericCoord.getTheta());
        double angle =  Math.acos(
            Math.cos(this.asSphericCoordinate().getPhi()) * Math.cos(sphericCoord.getPhi()) * Math.cos(deltaTheta)
        );
        assert !Double.isNaN(angle) && angle >= 0;
        return angle;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        this.assertClassInvariants();
        CartesianCoordinate comp = coordinate.asCartesianCoordinate();
        comp.assertClassInvariants();
        double x_dist = Math.pow(this.asCartesianCoordinate().getX() - comp.getX(), 2);
        double y_dist = Math.pow(this.asCartesianCoordinate().getY() - comp.getY(), 2);
        double z_dist = Math.pow(this.asCartesianCoordinate().getZ() - comp.getZ(), 2);
        double distance = Math.sqrt(x_dist + y_dist + z_dist);
        assert !Double.isNaN(distance) && distance >= 0;
        return distance;
    }

    public void assertClassInvariants() {}
}
