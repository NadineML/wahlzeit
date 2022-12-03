package org.wahlzeit.model;

public class Location {
    protected CartesianCoordinate coordinate;

	public Location(CartesianCoordinate coordinate){
        assertValidParameter(coordinate);
		setCoordinate(coordinate);
	}

    public void setCoordinate(CartesianCoordinate coordinate) {
        assertValidParameter(coordinate);
        this.coordinate = coordinate;
    }

    public CartesianCoordinate getCoordinate() {
        return this.coordinate;
    }



    @Override
    public boolean equals(Object object) {
        return isEquals(object);
    }
    
    public boolean isEquals(Object object) {
        assertValidParameter(object);
        if(object == null || object.getClass() != Location.class) {
            return false;
        }
        Location location = (Location) object;
        return this.coordinate.equals(location.coordinate);
    }

    public void assertValidParameter(Object param) throws IllegalArgumentException{
        if (param == null) {
            throw new IllegalArgumentException("The specified object is null");
        }
    }
        
}
