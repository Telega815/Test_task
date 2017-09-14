/**
 * Class conteins attributes cats. 
 * @autor telega815
 * @date 13.09.2017
 */
public class CatDog extends Animal{

	Cat cat;
	Dog dog;

	/**
 	 * Constructor
 	 * @param name Name of THAT
 	 * @param name Age of That
 	 */
	public CatDog(final String name, final int owner){
		super(name, "CatDog", "Mew-Bark", owner);
		dog = new Dog(name, owner);
		cat = new Cat(name, owner);
	}

	public String beUsefull(){
		return dog.beUsefull() + " and " + cat.beUsefull();
	}
}