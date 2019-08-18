package PriorityQueue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/* This class tests the methods of PriorityQueue.
 * @author Bhupendra
 */
public class TestPriorityQueue {
	
	// PriorityQueue object.
	PriorityQueue priorityQueue = new PriorityQueue(10);
	
	// Initializing the queue.
	@Before
	public void initialize()
	{
		priorityQueue.enqueue(new Job(21, "Job 1"));
		priorityQueue.enqueue(new Job(30, "Job 2"));
		priorityQueue.enqueue(new Job(20, "Job 3"));
		priorityQueue.enqueue(new Job(10, "Job 4"));
		priorityQueue.enqueue(new Job(9, "Job 5"));
		priorityQueue.enqueue(new Job(52, "Job 6"));
		priorityQueue.enqueue(new Job(14, "Job 7"));
		priorityQueue.enqueue(new Job(3, "Job 8"));
		priorityQueue.enqueue(new Job(8, "Job 9"));
		priorityQueue.enqueue(new Job(1, "Job 10"));
	}
	
	@Test
	public void testDequeue1()
	{
		assertEquals("Job 6", priorityQueue.dequeue().getJobName());
		assertEquals("Job 2", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
	}
	
	@Test(expected = AssertionError.class)
	public void testDequeue2()
	{
		assertEquals("Job 6", priorityQueue.dequeue().getJobName());
		assertEquals("Job 2", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
	}
	
	@Test(expected = AssertionError.class)
	public void testEnqueue()
	{
		priorityQueue.enqueue(new Job(15, "Job 11"));
	}
}