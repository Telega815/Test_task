package ru.test_task.tasks;

import java.util.ArrayList;
/**
 * @autor telega815
 * @date 13.09.2017
 */
public class Client {

	private String name;
	private final int id;
	private int animalCount = 0;
	private Animal emptyAnimal;
	ArrayList<Animal> animals = new ArrayList<Animal>();

	/**
 	 * Constructor
 	 */
	public Client(final String name, final String type, final String petName, final int id){
		this.name = name;
		this.id = id;
		emptyAnimal = Generator.createEmptyAnimal(id);
		addAnimal(type, petName, id);
	}

	public void addAnimal(final String type, final String petName, final int id){
		animals.add(Generator.createAnimal(petName, type, id));
		animalCount++;
	}

	public void addAnimal(final Animal animal){
		animals.add(animal);
		animalCount++;
	}

	public void removeAnimal(final String petName){
		animals.remove(findAnimal(petName));
	}

	public Animal findAnimal(final String petName){
		Animal foundedAnimal = emptyAnimal;;
		for (Animal animal : animals) {
			if(animal.getName() == petName)
				foundedAnimal = animal;
		}
		return foundedAnimal;
	}
}