package ViratKohli;

/* This is a component class. This class contains information about bowlers.
 * @author Bhupendra
 */
public class Bowler {
	
	// Instance variables.
	String name;
	int balls;
	
	// Constructor.
	public Bowler(String name, int balls) {
		this.name = name;
		this.balls = balls;
	}
	
	// This method returns the bowler's name.
	public String getName() {
		return this.name;
	}
	
	// This method returns the number of remaining balls of a bowler.
	public int getBalls() {
		return this.balls;
	}
}
