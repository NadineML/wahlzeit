package org.wahlzeit.model;
import java.sql.*;

import org.wahlzeit.services.SysLog;


public class AnimalPhotoFactory extends PhotoFactory {
	private static AnimalPhotoFactory instance = null;
	
	public static synchronized AnimalPhotoFactory getInstance() {
		if (instance == null) {
			SysLog.logSysInfo("setting generic PhotoFactory");
			setInstance(new AnimalPhotoFactory());
		}
		
		return instance;
	}
	
	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(AnimalPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize PhotoFactory twice");
		}
		
		instance = photoFactory;
	}

    public Photo createPhoto() {
		return new AnimalPhoto();
	}

    /**
	 * 
	 */
	public Photo createPhoto(PhotoId id) {
		assertValidParameter(id);
		return new AnimalPhoto(id);
	}

    /**
	 * 
	 */
	public Photo createPhoto(ResultSet rs) throws SQLException {
		assertValidParameter(rs);
		return new AnimalPhoto(rs);
	}

	public void assertValidParameter(Object param) throws IllegalArgumentException{
        if (param == null) {
            throw new IllegalArgumentException("The specified object is null");
        }
    }
}
