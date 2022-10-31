package org.wahlzeit.model;

public class Coordinate {
    private double x;
    private double y;
    private double z;

	public Coordinate(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
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

    public double getDistance(Coordinate comp){
        double x_dist = Math.abs(this.getX() - comp.getX());
        double y_dist = Math.abs(this.getY() - comp.getY());
        double z_dist = Math.abs(this.getZ() - comp.getZ());
        return Math.sqrt(x_dist + y_dist + z_dist);
    }

    @Override
    public boolean equals(Object object) {
        return isEqual(object);
    }

    public boolean isEqual(Object object) {
        if(object == null || object.getClass() != Coordinate.class) {
            return false;
        }
        Coordinate c = (Coordinate) object;
        return (this.getX() == c.getX() && this.getY() == c.getY() && this.getZ() == c.getZ());
    }
}
