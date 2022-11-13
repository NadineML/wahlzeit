package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{
    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if(coordinate == null || coordinate.getClass() != SphericCoordinate.class) {
            return false;
        }
        SphericCoordinate c = (SphericCoordinate) coordinate;
        return (this.getPhi() == c.getPhi() && this.getTheta() == c.getTheta() && this.getRadius() == c.getRadius());
    }

    private double getRadius() {
        return this.radius;
    }

    private double getTheta() {
        return this.theta;
    }

    private double getPhi() {
        return this.phi;
    }

}
