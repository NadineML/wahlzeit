package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
    private double x;
    private double y;
    private double z;

	public CartesianCoordinate(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
        assertClassInvariants();
	}
    
    public double getX() {
        return x;
	}

    public void setX(double x) {
        this.x = x;
	}

    public double getY() {
        return y;
	}

    public void setY(double y) {
        this.y = y;
	}

    public double getZ() {
        return z;
	}

    public void setZ(double z) {
        this.z = z;
	}

    @Override
    public void assertClassInvariants() {
        assert !Double.isNaN(x);
        assert !Double.isNaN(y);
        assert !Double.isNaN(z);
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
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        
        assert !Double.isNaN(phi) && Math.abs(phi) <= Math.PI;
        assert !Double.isNaN(theta) && theta >= 0;
        assert !Double.isNaN(radius) && radius >= 0;
        
        return sphericCoordinate;
    }

}
