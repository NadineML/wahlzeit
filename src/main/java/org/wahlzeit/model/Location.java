package org.wahlzeit.model;

public class Location {
    protected CartesianCoordinate coordinate;

	public Location(CartesianCoordinate coordinate){
		setCoordinate(coordinate);
	}

    public void setCoordinate(CartesianCoordinate coordinate) {
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
        if(object == null || object.getClass() != Location.class) {
            return false;
        }
        Location location = (Location) object;
        return this.coordinate.equals(location.coordinate);
    }

}
