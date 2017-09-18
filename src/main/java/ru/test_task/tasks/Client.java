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
	private ArrayList<Animal> animals = new ArrayList<Animal>();

	/**
 	 * Constructor
 	 */
	public Client(final String name, final int id){
		this.name = name;
		this.id = id;
	}

	public String getName(){
		return name;
	}
	public void setName(final String name){
		this.name = name;
	}

	public int getId() { return id; }

	//-------------------------------------------------------------

	public Animal addAnimal( final String petName, final String type, final int id){
		Animal animal = Generator.createAnimal(petName, type, id);
		animals.add(animal);
		animalCount++;
		return animal;
	}

	public void addAnimal(final Animal animal){
		animals.add(animal);
		animalCount++;
	}

	public boolean removeAnimal(Animal removingAnimal){
		boolean result = false;
		for (Animal animal : animals){
			if (animal.getName().equals(removingAnimal.getName())){
				result = animals.remove(animal);
				break;
			}
		}
		return result;

	}

	public Animal findAnimal(final String petName) throws UserExeption{
		Animal foundedAnimal = null;
		for (Animal animal : animals) {
			if(animal.getName().equals(petName))
				foundedAnimal = animal;
			else {
				throw new UserExeption("There's no animal with that name");
			}
		}
		return foundedAnimal;
	}
}