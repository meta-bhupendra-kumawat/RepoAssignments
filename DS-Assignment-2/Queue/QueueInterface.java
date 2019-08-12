package Queue;
 
/* This is an interface. This class consists of abstract methods to implement Queue data structure.
 * @author Bhupendra
 */
public interface QueueInterface {

	/* This method adds an element to the queue.
	 * @param a element to add.
	 * @return true if the element is sucessfully added to the Queue.
	 */
	boolean enqueue(int a);
	
	/* This method is used to delete an element form the Queue.
	 * @return the deleted element.
	 */
	int dequeue();
	
	/* This method checks whether the Queue is empty or not.
	 * @return true if the Queue is empty, false otherwise.
	 */
	boolean isEmpty();
	
	/* This method checks whether the Queue is full or not.
	 * @return true if the Queue is full, false otherwise.
	 */
	boolean isFull();
}
