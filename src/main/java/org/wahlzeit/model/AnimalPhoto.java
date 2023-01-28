package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/* 
Object creation table:
- Delegation: separate-object
- Selection: by-subclassing 
- Configuration: in-code
- Instantiation: in-code
- Initialization: default
- Building: default 
*/

/*
AnimalPhoto - Animal Collaboration:
- Collaboration Type: Client-Service
- Role: client
- Binds: Animal
*/



public class AnimalPhoto extends Photo {
    private Animal animal;

    // different constructors for AnimalPhoto, called by createPhoto methods in AnimalPhotoFactory
    public AnimalPhoto(PhotoId id) {
        super(id);
    }

    public AnimalPhoto() {
        super();
    }

    public AnimalPhoto(ResultSet rs) throws SQLException {
        super(rs);
    }
    
    public AnimalPhoto(Animal animal) {
        super();
        this.animal = animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
