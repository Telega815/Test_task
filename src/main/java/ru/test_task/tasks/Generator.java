package ru.test_task.tasks;
/**
 * @autor telega815
 * @date 13.09.2017
 */
public class Generator {

	public static Animal createAnimal(final String name, final String type, final int id){
		Animal animal = createEmptyAnimal(id);
		if (type.equals("Cat"))
			animal = createCat(name,id);
		else if (type.equals("Dog"))
			animal = createDog(name, id);
		else if (type.equals("CatDog"))
			animal = createCatDog(name, id);
		// Need to close that hole;
		return animal;
	}

	public static EmptyAnimal createEmptyAnimal(final int id){
		return new EmptyAnimal(id);
	}

	private static Cat createCat(final String name, final int id){
		return new Cat(name, id);
	}

	private static Dog createDog(final String name, final int id){
		return new Dog(name, id);
	}

	private static CatDog createCatDog(final String name, final int id){
		return new CatDog(name, id);
	}

	//------------------------------------------------------------------------


	
}