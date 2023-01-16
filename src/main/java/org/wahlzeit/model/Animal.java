package org.wahlzeit.model;

public class Animal {
    private static int numberOfInstances = 0;

    private final AnimalType animalType;
    private final int id;

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