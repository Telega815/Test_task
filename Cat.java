/**
 * Class conteins attributes cats. 
 * @autor telega815
 * @date 13.09.2017
 */
public class Cat extends Animal{
	/**
 	 * Constructor
 	 * @param name Name of cat
 	 * @param name Age of cat 
 	 */
	public Cat(final String name, final int owner){
		super(name, "Cat", "Mew", owner);
	}

	public String beUsefull(){
		return "Mouse is dead";
	}
}