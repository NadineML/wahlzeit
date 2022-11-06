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

    protected Photo createObject(ResultSet rset) throws SQLException {
		return AnimalPhotoFactory.getInstance().createPhoto(rset);
	}
}
