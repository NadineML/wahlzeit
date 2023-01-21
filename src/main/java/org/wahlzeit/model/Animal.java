package org.wahlzeit.model;

/* 
Object creation table:
- Delegation: separate-object
- Selection: by-subclassing 
- Configuration: in-code
- Instantiation: in-code
- Initialization: default
- Building: default 
*/
public class Animal {
    private static int numberOfInstances = 0;

    private final AnimalType animalType;
    private final int id;

    // the constructor of Animal is called by the createInstance method in AnimalType
    public Animal(AnimalType animalType) {
        if(animalType == null) {
            throw new IllegalArgumentException("AnimalType should not be null!");
        }

        this.animalType = animalType;
        id = numberOfInstances++;
    }

    public AnimalType getType() {
        return this.animalType;
    }

    public int getId() {
        return this.id;
    }

}