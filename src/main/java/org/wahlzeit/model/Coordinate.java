package org.wahlzeit.model;

public interface Coordinate {
    public CartesianCoordinate asCartesianCoordinate();
    public double getCartesianDistance(Coordinate coordinate);
    public SphericCoordinate asSphericCoordinate();
    public double getCentralAngle(Coordinate coordinate);
    public boolean isEqual(Coordinate coordinate);
    public void assertClassInvariants();
    public Coordinate getCoordinate(double param1, double param2, double param3);
}
