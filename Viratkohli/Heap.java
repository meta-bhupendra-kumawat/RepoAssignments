package ViratKohli;
import java.util.ArrayList;
import java.util.List;

/* This class uses heap data structure for solving the given problem statement. The mac heap will
 * be maintained based on the remaining balls of each bowler.
 * @author Bhupendra
 */
public class Heap {
	// Instance variables.
	Bowler bowlers[];
	private int numberOfbowlers;
	public int size;
	
	// Constructor.
	public Heap(int numberOfbowlers) {
		this.numberOfbowlers = numberOfbowlers;
		bowlers = new Bowler[numberOfbowlers + 1];
		this.size = 0;
		bowlers[0] = new Bowler("XYXY", Integer.MAX_VALUE);
	}
	
	/* This method is used to find the index of the parent node.
	 * @param position node index.
	 * @return index of parent node.
	 */
	private int parent(int position) {
		return position / 2;
	}
	
	/* This method is used to find the index of the left child of the current node.
	 * @param position of current node.
	 * @return index of left child.
	 */
	private int leftChild(int position) {
		return (2 * position);
	}
	
	/* This method is used to find the index of the right child of the current node.
	 * @param position of current node.
	 * @return index of right child.
	 */
	private int rightChild(int position) {
		return (2 * position) + 1;
	}
	
	/* This method check for the leaf node.
	 * @param position index of the current node.
	 * @return true if the node at given index is leaf node.
	 */
	public boolean isLeaf(int position) {
		if(position >= (size / 2) && position <= size) 
			return true;
			
		return false;
	}
	
	/* This method makes the tree to satisfy the heap condidtion that is max heap.
	 * @param position index of node.
	 */
	public void heapify(int position) {
		if(isLeaf(position))
			return;
		
		if(bowlers[position].balls < bowlers[leftChild(position)].balls ||
				bowlers[position].balls < bowlers[rightChild(position)].balls) {
			
			// If left child is greater than right child. Else the right child is greater than left child.
			if(bowlers[leftChild(position)].balls > bowlers[rightChild(position)].balls) {
				this.swap(bowlers, position, leftChild(position));
				this.heapify(leftChild(position));
			}else {
				this.swap(bowlers, position, rightChild(position));
				this.heapify(rightChild(position));
			}
		}
	}
	
	/* This method insert a new node to the heap.
	 * @param b bowler object as new node.
	 */
	public void insert(Bowler b) {
		if(b == null)
			throw new AssertionError("Null value.");
		
		bowlers[++size] = b;
		int currentIndex = size;
		while(bowlers[currentIndex].balls > bowlers[parent(currentIndex)].balls) {
			this.swap(bowlers, currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}
	}
	
	/* This method exracts the top element that is the maximum element from max heap.
	 * @return node of type bowler.
	 */
	public Bowler extractMax() {
		if(size == 0)
			throw new AssertionError("No delivery left");
		Bowler b = bowlers[1];
		bowlers[1] = bowlers[size--];
		heapify(1);
		return b;
	}

	/* This method swaps the object present at the i and j index of array.
	 * @param bowlers aray of object Bowler.
	 * @param i index.
	 * @param j index.
	 */
	public void swap(Bowler bowlers[], int i, int j) {
		Bowler temp = bowlers[i];
		bowlers[i] = bowlers[j];
		bowlers[j] = temp;
	}
	
	// This method prints the heap.
	public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + bowlers[i].name + " Balls left-" + bowlers[i].balls + 
            		" LEFT CHILD : " + bowlers[2 * i].name + " Balls left-" + bowlers[2 * i].balls + 
            		" RIGHT CHILD :" + bowlers[2 * i + 1].name + " Balls left-" + bowlers[2 * i + 1].balls); 
            System.out.println(); 
        } 
    }
	
	/* This method makes Virat to play such that its score should be minimum, i.e the bowler having
	 * maximum balls remaining will bowl first.
	 * @return list of delivery of bowlers.s
	 */
	public List<Bowler> play() {
		List<Bowler> bowling = new ArrayList<Bowler>();
		Bowler b;
		while(size != 0) {
			b = this.extractMax();
			bowling.add(new Bowler(b.getName(), b.getBalls()));
			b.balls = b.balls - 1;
			if(b.balls > 0){
				this.insert(b);
			}
			heapify(1);
		}
		return bowling;
	} 
}
