package org.wahlzeit.model;

import java.sql.*;


public class AnimalPhotoManager extends PhotoManager {

	protected static final AnimalPhotoManager instance = new AnimalPhotoManager();

    public AnimalPhotoManager() {
		photoTagCollector = AnimalPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	public static final AnimalPhotoManager getInstance() {
		return instance;
	}

	// creates an AnimalPhoto via calls to AnimalPhotoFactroy -> AnimalPhoto
    protected Photo createObject(ResultSet rset) throws SQLException {
		assertValidParameter(rset);
		return AnimalPhotoFactory.getInstance().createPhoto(rset);
	}

	public void assertValidParameter(Object param) throws IllegalArgumentException{
        if (param == null) {
            throw new IllegalArgumentException("The specified object is null");
        }
    }
}
