package org.wahlzeit.model;

import java.sql.*;


public class AnimalPhotoManager extends PhotoManager {
    public AnimalPhotoManager() {
		photoTagCollector = AnimalPhotoFactory.getInstance().createPhotoTagCollector();
	}

    protected Photo createObject(ResultSet rset) throws SQLException {
		return PhotoFactory.getInstance().createPhoto(rset);
	}
}
