package org.wahlzeit.model;
import org.wahlzeit.annotations.PatternInstance;

@PatternInstance( 
	patternName = "Template Method",
	participants = {"AbstractClass"}
)

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
        CartesianCoordinate this_coord = this.asCartesianCoordinate();
        return (this_coord.getX() == c.getX() && this_coord.getY() == c.getY() && this_coord.getZ() == c.getZ());
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

        assertValidParameter(angle, 0, -1);
        return angle;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        this.assertClassInvariants();
        CartesianCoordinate comp = coordinate.asCartesianCoordinate();
        assertValidParameter(comp.getX(), 0, -1);
        assertValidParameter(comp.getY(), 0, -1);
        assertValidParameter(comp.getZ(), 0, -1);
        double x_dist = Math.pow(this.asCartesianCoordinate().getX() - comp.getX(), 2);
        double y_dist = Math.pow(this.asCartesianCoordinate().getY() - comp.getY(), 2);
        double z_dist = Math.pow(this.asCartesianCoordinate().getZ() - comp.getZ(), 2);
        double distance = Math.sqrt(x_dist + y_dist + z_dist);
        assertValidParameter(distance, 0, -1);
        return distance;
    }

    public boolean assertValidParameter(double param, double lower_bound, double upper_bound) throws IllegalArgumentException{
        double epsilon = 0.001;
        if (Double.isNaN(param)){
            throw new IllegalArgumentException("The specified double parameter is a NaN value!");
        } else if (lower_bound > 0 && param + epsilon < lower_bound) {
            throw new IllegalArgumentException("The specified double parameter is too small!(< " +lower_bound+")!");
        } else if (upper_bound > 0 && param > upper_bound+epsilon) {
            throw new IllegalArgumentException("The specified double parameter is too large (> " +upper_bound+")!");
        }
        return true;
    }

}
