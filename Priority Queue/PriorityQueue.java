package PriorityQueue;

/* This is a component class. This class implements the PriorityQueue interface.
 * This class overrides the functionality of PriorityQueueInterface.
 * @author Bhupendra
 */
public class PriorityQueue implements PriorityQueueInterface  {
	
	// Instance variables.
	int size;
	Job queue[];
	int front;
	int rear;
	
	// Constructor.
	public PriorityQueue( int size) {
		this.size = size;
		queue = new Job[ size ];
		front = -1;
		rear = - 1;
	}

	/* This method adds job to the queue.
	 * @param j job.
	 * @return true if the job is successfully entered the queue, false otherwise.
	 */
	@Override
	public boolean enqueue(Job j) {
		if(this.isFull()) {
			throw new AssertionError("Queue is full!");
		}
		if(front == -1) 
			front = (front + 1) % size;

		rear = (rear + 1) % size;
		queue[ rear ] = j;
		return true;
	}

	/* This method pops the job out if the queue. The job with highest priority will 
	 * be dequeued first.
	 * @return job.
	 */
	@Override
	public Job dequeue() {
		if(isEmpty())
			throw new AssertionError("Queue is Empty!");
		
		int maxPriority = Integer.MIN_VALUE;
		int maxPriorityIndex = front;
		for(int i = front; i < rear + 1; i++) {
			if(queue[i].getPriority() > maxPriority) {
				maxPriority = queue[i].getPriority();
				maxPriorityIndex = i;
			}
		}
		Job a = this.queue[maxPriorityIndex];
		
		if(maxPriorityIndex == front)
			front = (front + 1) % size;
		else if(maxPriorityIndex == rear)
			rear = (rear - 1) % size;
 		else {
			for(int j = maxPriorityIndex; j < rear; j = (j + 1) % size) {
				queue[j] = queue[j + 1];
			}
			queue[rear] = null;
			rear = (rear - 1) % size;
		}
		if(front - rear == 1) {
			front = -1;
			rear = -1;
		}
		return a;
	}

	/* This method is used to check whether the queue is empty or not.
	 * @return true if queue is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if(front == -1 && rear == -1)
			return true;
			
		return false;
	}

	/* This method is used to check whether the queue is full or not.
	 * @return true if queue is full, false otherwise.
	 */
	@Override
	public boolean isFull() {
		if(front == 0 && rear == size - 1)
			return true;
		if(front - rear == 1)
			return true;
		return false;
	}
	
	// This method prints all the jobs in the queue.
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is empty!!");
			return;
		}
		for (int i = front; i <= rear; i++)
			System.out.print(this.queue[i].getJobName() + " --> ");
	}
 }
