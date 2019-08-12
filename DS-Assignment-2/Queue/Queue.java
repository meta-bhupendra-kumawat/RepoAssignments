package Queue;

/* This is a component class. This is an interface. This class consists of 
 * abstract methods to implement Queue data structure.
 * @author Bhupendra
 */
public class Queue implements QueueInterface{
	
	// Instance variables.
	int size;
	int queue[];
	int front;
	int rear;
	
	// Constructor.
	public Queue( int size) {
		this.size = size;
		queue = new int[ size ];
		front = -1;
		rear = - 1;
	}

	/* This method adds an element to the queue.
	 * @param a element to add.
	 * @return true if the element is sucessfully added to the Queue.
	 */
	@Override
	public boolean enqueue(int a) {
		if(this.isFull()) {
			throw new AssertionError("Queue is full!");
		}
		if(front == -1) 
			front = (front + 1) % size;

		rear = (rear + 1) % size;
		queue[ rear ] = a;
		return true;
	}

	/* This method is used to delete an element form the Queue.
	 * @return the deleted element.
	 */
	@Override
	public int dequeue() {
		if(isEmpty())
			throw new AssertionError("Queue is Empty!");
		int a = this.queue[front];
		front = (front + 1) % size;
		if(front - rear == 1) {
			front = -1;
			rear = -1;
		}
		return a;
	}

	/* This method checks whether the Queue is empty or not.
	 * @return true if the Queue is empty, false otherwise.
	 */
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

	/* This method checks whether the Queue is full or not.
	 * @return true if the Queue is full, false otherwise.
	 */
	@Override
	public boolean isFull() {
		if(front == 0 && rear == size - 1)
			return true;
		if(front - rear == 1)
			return true;
		return false;
	}
	
	// This method prints the elements of the Queue.
	public void print() {
		
		for (int i = front; i <= rear; i++)
			System.out.print(this.queue[i] + " --> ");
	}
}
