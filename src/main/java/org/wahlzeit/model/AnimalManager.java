package org.wahlzeit.model;

import java.util.HashMap;

public class AnimalManager {

    protected static final AnimalManager instance = new AnimalManager();
    private final HashMap<Integer, Animal> animals = new HashMap<>();
    private final HashMap<String, AnimalType> animalTypes = new HashMap<>();

    public static AnimalManager getInstance() {
        return instance;
    }

    // creates Animal instance via calls to AnimalType to Animal
    public Animal createAnimal(String typeName) {
        if(typeName == null) {
            throw new IllegalArgumentException("TypeName should not be null!");
        }

        AnimalType animalType = getAnimalType(typeName);
        Animal result = animalType.createInstance();
        animals.put(result.getId(), result);
        return result;
    }

    private void addAnimalType(String typeName) {
        animalTypes.put(typeName, new AnimalType(typeName));
    }

    public AnimalType getAnimalType(String typeName) {
        if(!animalTypes.containsKey(typeName)) {
            addAnimalType(typeName);
        }
        return animalTypes.get(typeName);
    }
}