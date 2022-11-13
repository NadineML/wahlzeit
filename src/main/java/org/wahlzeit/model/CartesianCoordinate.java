package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{
    private double x;
    private double y;
    private double z;

	public CartesianCoordinate(double x, double y, double z) {
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

    @Override
    public boolean equals(Object object) {
        return isEqual(object);
    }

    public boolean isEqual(Object object) {
        if(object == null || object.getClass() != CartesianCoordinate.class) {
            return false;
        }
        CartesianCoordinate c = (CartesianCoordinate) object;
        return (this.getX() == c.getX() && this.getY() == c.getY() && this.getZ() == c.getZ());
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate comp = (CartesianCoordinate) coordinate;
        double x_dist = Math.pow(this.getX() - comp.getX(), 2);
        double y_dist = Math.pow(this.getY() - comp.getY(), 2);
        double z_dist = Math.pow(this.getZ() - comp.getZ(), 2);
        return Math.sqrt(x_dist + y_dist + z_dist);
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
        return isEqual(coordinate);
    }
}
