
/* This is an interface which consists of some methods used for implementing data structure.
 * @author Bhupendra
 */
public interface QueueInterface {

	/* This method add some object to the queue.
	 * @param a object.
	 * @return true if the object is successfully added to queue.
	 */
	boolean enqueue(StudentPreferences a);
	
	/* This method eject the object from the queue. The one with the highest priority will be
	 * ejected first.
	 * @return the ejected object.
	 */
	StudentPreferences dequeue();
	
	/* This method is used to check whether the queue is empty or not.
	 * @return true if the queue is empty, false otherwise.
	 */
	boolean isEmpty();
	
	/* This method is used to check whether the queue is full or not.
	 * @return true if the queue is full, false otherwise.
	 */
	boolean isFull();
}
