package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
    private final double phi;
    private final double theta;
    private final double radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        assertClassInvariants();
    }

    public double getRadius() {
        return this.radius;
    }

    public double getTheta() {
        return this.theta;
    }

    public double getPhi() {
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
    public void assertClassInvariants() {
        assertValidParameter(phi, -Math.PI, Math.PI);
        assertValidParameter(theta, 0, -1);
        assertValidParameter(radius, 0, -1);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();
        return this;
    }

}
