package ru.test_task.tasks;

/**
 * Class conteins common attributes of any animal. 
 * @autor telega815
 * @date 13.09.2017
 * @param name Animal name
 * @param age Age of animal
 * @param sound Sound that animal do.
 * @param type Animal spicies
 */
public abstract class Animal {

	private int owner;
	private String name;
	private final String sound;
	private final String type;

	//constructor
	public Animal(final String name, final String type, final String sound, final int owner){
		this.name = name;
		this.type = type;
		this.sound = sound;
		this.owner = owner;
	}

 	/**
  	 * @return sound that animal do.
  	 */
	public String makeSound(){
		return sound;
	}

	public abstract String beUsefull();



    /**
     * Getter and setter of name
  	 * @return name.
  	 */
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}