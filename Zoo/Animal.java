
/* This is a component class.
 * This is an abstract class and consists of some abstract methods.
 * @author Bhupendra
 */
public abstract class Animal {
	
	// Instance variables.
	static int counter = 1; 
	final int animalId;
    String uniqueName;
    String animalName;
	String category;
	int age;
	double weight;
	Zone zone;
	Cage cage;
	public Animal(){
		animalId = counter++;
	}
	
	/* This is an abstract method. This methods will be overidden by sub-classes.
	 * @return sound of animals.
	 */
	public abstract String getSound();
}
