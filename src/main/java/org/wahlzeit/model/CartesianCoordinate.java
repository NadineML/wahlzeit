package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartesianCoordinate extends AbstractCoordinate{
    private final double x;
    private final double y;
    private final double z;

    private final static ArrayList<CartesianCoordinate> coord_objects = new ArrayList<CartesianCoordinate>();

	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
        this.z = z;
        assertClassInvariants();
        coord_objects.add(this);
	}
    
    public double getX() {
        return x;
	}

    public double getY() {
        return y;
	}

    public double getZ() {
        return z;
	}

    @Override
    public void assertClassInvariants() {
        assertValidParameter(x, -1, -1);
        assertValidParameter(y, -1, -1);
        assertValidParameter(z, -1, -1);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)+ Math.pow(z, 2));
        double theta = Math.acos(z/radius);
        double phi = Math.atan2(y,x);
        SphericCoordinate sphericCoordinate = SphericCoordinate.getCoordinate(phi, theta, radius).asSphericCoordinate();
        
        assert !Double.isNaN(phi) && Math.abs(phi) <= Math.PI;
        assert !Double.isNaN(theta) && theta >= 0;
        assert !Double.isNaN(radius) && radius >= 0;
        
        return sphericCoordinate;
    }

    public static Coordinate getCoordinate(double x, double y, double z) {
        List<CartesianCoordinate> objs = coord_objects.stream().filter(a -> a.x == x).filter(a -> a.y == y).filter(a -> a.z == z).collect(Collectors.toList());
        if(!objs.isEmpty()){
            return objs.get(0);
        } else {
            return new CartesianCoordinate(x, y, z);
        }
    }

}
