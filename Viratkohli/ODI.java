package ViratKohli;

import java.util.List;

/* This is an application class. This class makes Virat Kohli to play an ODI.
 * @author Bhupendra
 */
public class ODI {

	public static void main(String[] args) {
		Heap maxheap = new Heap(5);
		maxheap.insert(new Bowler("Bumrah", 7));
		maxheap.insert(new Bowler("Shami", 4));
		maxheap.insert(new Bowler("Starc", 4));
		maxheap.insert(new Bowler("Chahal", 6));

		System.out.println("\n");
		
		List<Bowler> bowlingSequence = maxheap.play();
		for(Bowler b : bowlingSequence) {
			System.out.println("Bowler : " + b.getName() + "\tballs : " + b.getBalls());
		}
	}
}
