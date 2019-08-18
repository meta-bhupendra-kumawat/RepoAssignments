package PriorityQueue;

/* This is an Application class. This class uses the functionality of priority queue.
 * @author Bhupendra
 */
public class UsePriorityQueue {
	public static void main(String args[]) 	{
		PriorityQueue pq = new PriorityQueue(10);
		pq.enqueue(new Job(1, "a1"));
		pq.enqueue(new Job(20, "a2"));
		pq.enqueue(new Job(30, "a3"));
		pq.enqueue(new Job(4, "A4"));
		pq.enqueue(new Job(3, "a5"));
		pq.print();
		System.out.println("\n"+pq.dequeue().getJobName());
		System.out.println(pq.dequeue().getJobName());
		System.out.println(pq.dequeue().getJobName());		
		System.out.println(pq.dequeue().getJobName());	
		System.out.println(pq.dequeue().getJobName());
		pq.print();
	}
}
