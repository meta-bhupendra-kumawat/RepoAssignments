
/* This is a component class.
 * This class extends the functionality of its super-class named Mammal.
 * @author Bhupendra
 */
public class Lion extends Mammal {

	// Constructor
	public Lion(int age, double weight, String name)
	{
		this.age = age;
		this.weight = weight;
		this.animalName = "LION";
		this.uniqueName = this.animalName + "-" + this.animalId;	
	}
	
	/* This is an Overriden method.
	 * (non-Javadoc)
	 * @see Animal#getSound()
	 * return sound of animal as string.
	 */
	public String getSound() {
		return "Roars";
	}
}
