
/* This is a component class.
 * This class extends the functionality of its super-class named Reptile.
 * @author Bhupendra
 */
public class Crocodile extends Reptile {
	
	// Constructor
	public Crocodile(int age, double weight, String name)
	{
		this.age = age;
		this.weight = weight;
		this.uniqueName = name + "-" + this.animalId;	
	}

	/* This is an Overriden method.
	 * (non-Javadoc)
	 * @see Animal#getSound()
	 * return sound of animal as string.
	 */
	public String getSound() {
		return "Bellows";
	}
}
