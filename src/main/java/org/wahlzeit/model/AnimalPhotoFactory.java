package org.wahlzeit.model;
import java.sql.*;


public class AnimalPhotoFactory extends PhotoFactory {
    public Photo createPhoto() {
		return new AnimalPhoto();
	}

    /**
	 * 
	 */
	public Photo createPhoto(PhotoId id) {
		return new AnimalPhoto(id);
	}

    /**
	 * 
	 */
	public Photo createPhoto(ResultSet rs) throws SQLException {
		return new AnimalPhoto(rs);
	}
}
