package org.wahlzeit.model;
import java.util.Iterator;
import java.util.HashSet;

/*
AnimalType - Animal Collaboration:
- Collaboration Type: Type-Object
- Role: Type Object
- Binds: Animal
*/

public class AnimalType {

	private AnimalType superType;
	private final HashSet<AnimalType> subTypes;
	private final String typeName;

	
	public AnimalType(String typeName) {
		if(typeName == null) {
			throw new IllegalArgumentException("TypeName should not be null!");
		}
		this.typeName = typeName;
		subTypes = new HashSet<AnimalType>();
	}

	// calls constructor of Animal, is called by createAnimal method in AnimalManager
	public Animal createInstance() {
		return new Animal(this);
	}

	public String getTypeName() {
		return typeName;
	}

	public AnimalType getSuperType() {
		return superType;
	}

	public void setSuperType(AnimalType animalType) {
		superType = animalType;
	}

	public Iterator<AnimalType> getSubTypeIterator() {
		return subTypes.iterator();
	}


	public void setSubType(AnimalType animalType) {
		assert(animalType != null) : "tried to set subtype to null";
		animalType.setSuperType(this);
		subTypes.add(animalType);
	}


	public boolean hasInstance(Animal animal) {
		assert (animal != null) : "asked about null object";
		if (animal.getType() == this) {
		return true;
		}
		for (AnimalType type : subTypes) {
			if (type.hasInstance(animal)) {
				return true;
			}
		}
		return false;
	}

	public boolean isSubtype() {
		return superType != null;
	}
}