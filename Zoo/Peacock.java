
/* This is a component class.
 * This class extends the functionality of its super-class named Bird.
 * @author Bhupendra
 */
public class Peacock extends Bird{

	// Constructor
	public Peacock(int age, double weight, String name)
	{
		this.age = age;
		this.weight = weight;
		this.category = "BIRD";
		this.animalName = "PEACOCK";
		this.uniqueName = this.animalName + "-" + this.animalId;	
	}
	
	/* This is a component class.
	 * This class extends the functionality of its super-class named Reptile.
	 * @author Bhupendra
	 */
	public String getSound() {
		return "Scream";
	}
}
