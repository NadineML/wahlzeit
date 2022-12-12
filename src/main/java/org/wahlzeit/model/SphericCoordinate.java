package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SphericCoordinate extends AbstractCoordinate {
    private final double phi;
    private final double theta;
    private final double radius;

    private final ArrayList<SphericCoordinate> coord_objects = new ArrayList<SphericCoordinate>();

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        assertClassInvariants();
        coord_objects.add(this);
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

    @Override
    public Coordinate getCoordinate(double phi, double theta, double radius) {
        List<SphericCoordinate> objs = coord_objects.stream().filter(x -> x.phi == phi).filter(x -> x.theta == theta).filter(x -> x.radius == radius).collect(Collectors.toList());
        if(!objs.isEmpty()){
            return objs.get(0);
        } else {
            return new SphericCoordinate(phi, theta, radius);
        }
    }

}
