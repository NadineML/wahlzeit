package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalPhoto extends Photo {

    public AnimalPhoto(PhotoId id) {
        super(id);
    }

    public AnimalPhoto() {
        super();
    }

    public AnimalPhoto(ResultSet rs) throws SQLException {
        super(rs);
    }
    
}
