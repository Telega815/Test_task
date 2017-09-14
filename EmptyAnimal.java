/**
 * Class conteins attributes cats. 
 * @autor telega815
 * @date 13.09.2017
 */
public class EmptyAnimal extends Animal{
	/**
 	 * Constructor
 	 * @param name Name of cat
 	 * @param name Age of cat 
 	 */
	public EmptyAnimal(final int owner){
		super("There's no animal", "None", "There's no animal", owner);
	}

	public String beUsefull(){
		return "There's no animal";
	}
}