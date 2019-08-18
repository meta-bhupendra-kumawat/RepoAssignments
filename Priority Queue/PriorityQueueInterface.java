package PriorityQueue;

/* This is an interface, used for implementing priority queue for scheduling jobs. 
 * @author Bhupendra
 */
public interface PriorityQueueInterface {
	
	/* This method adds job to the queue.
	 * @param j job.
	 * @return true if the job is successfully entered the queue, false otherwise.
	 */
	boolean enqueue(Job j);
	
	/* This method pops the job out if the queue. The job with highest priority will 
	 * be dequeued first.
	 * @return job.
	 */
	Job dequeue();
	
	/* This method is used to check whether the queue is empty or not.
	 * @return true if queue is empty, false otherwise.
	 */
	boolean isEmpty();
	
	/* This method is used to check whether the queue is full or not.
	 * @return true if queue is full, false otherwise.
	 */
	boolean isFull();
}
