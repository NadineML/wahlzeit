package org.wahlzeit.model;

public class Location {
    protected Coordinate coordinate;

	public Location(Coordinate coordinate){
		setCoordinate(coordinate);
	}

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
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
