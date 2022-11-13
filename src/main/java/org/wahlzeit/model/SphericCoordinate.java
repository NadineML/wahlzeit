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

    private double getRadius() {
        return this.radius;
    }

    private double getTheta() {
        return this.theta;
    }

    private double getPhi() {
        return this.phi;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius*Math.sin(theta)*Math.cos(phi);
        double y = radius*Math.sin(theta)*Math.sin(phi);
        double z = radius*Math.cos(theta);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();
        double deltaTheta = Math.abs(this.theta - sphericCoord.theta);
        return Math.acos(
            Math.sin(this.phi) * Math.sin(sphericCoord.phi) + 
            Math.cos(this.phi) * Math.cos(sphericCoord.phi) * Math.cos(deltaTheta)
        );
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if(coordinate == null || coordinate.getClass() != SphericCoordinate.class) {
            return false;
        }
        SphericCoordinate c = (SphericCoordinate) coordinate;
        return (this.getPhi() == c.getPhi() && this.getTheta() == c.getTheta() && this.getRadius() == c.getRadius());
    }



}
