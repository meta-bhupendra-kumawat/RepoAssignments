
/* This is a component class. This class implements QueueInterface interface.
 * @author Bhupendra
 */
public class Queue implements QueueInterface{
	
	// Instance variables.
	int size;
	StudentPreferences queue[];
	int front;
	int rear;
	
	// Constructor.
	public Queue( int size) {
		this.size = size;
		queue = new StudentPreferences[ size ];
		front = -1;
		rear = - 1;
	}

	/* This method performs enqueue operation. The StudentPreferences will be queued for counseling
	 * process.
	 * return true if the student's preference is added to queue.
	 */
	@Override
	public boolean enqueue(StudentPreferences a) {
		if(this.isFull()) {
			throw new AssertionError("Queue is full!");
		}
		if(front == -1) 
			front = (front + 1) % size;

		rear = (rear + 1) % size;
		queue[ rear ] = a;
		return true;
	}

	/* This method allocate the preferred branch to the students according to their preferences and 
	 * the availability of program.
	 */
	@Override
	public StudentPreferences dequeue() { 
		if(isEmpty())
			throw new AssertionError("Queue is Empty!");
		StudentPreferences a = this.queue[front];
		front = (front + 1) % size;
		if(front - rear == 1) {
			front = -1;
			rear = -1;
		}
		return a;
	}

	// This method returns true if the queue is empty, false otherwise.
	@Override
	public boolean isEmpty() {
		if(front == -1 && rear == -1)
			return true;
		if(front == rear)
			return true;
		if(front - rear == 1)
			return true;
			
		return false;
	}

	// This method returns true if the queue is full, false otherwise.
	@Override
	public boolean isFull() {
		if(front == 0 && rear == size - 1)
			return true;
		if(front - rear == 1)
			return true;
		return false;
	}
	
	// This method prints the contents of the queue.
	public void print() {
		
		for (int i = front; i <= rear; i++)
			System.out.print(this.queue[i] + " --> ");
	}
}
