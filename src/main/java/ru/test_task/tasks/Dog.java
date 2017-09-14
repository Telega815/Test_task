package ru.test_task.tasks;

/**
 * @autor telega815
 * @date 13.09.2017
 */
public class Dog extends Animal{
	/**
 	 * Constructor
 	 * @param name Name of dog
 	 * @param name Age of dog
 	 */
	public Dog(final String name, final int owner){
		super(name, "Dog", "Bark", owner);
	}

	public String beUsefull(){
		return "House is safe";
	}
}