package Queue;

import static org.junit.Assert.*;

import org.junit.Test;

/* This class consists of the test cases used to test the methods of Queue interface.
 * @author Bhupendra
 */
public class QueueTest {
	
	@Test
	public void testQueueStatus1() throws Exception	{
		Queue queue = new Queue(10);
		queue.enqueue(1);
		queue.enqueue(2);
		
		assertEquals(false, queue.isEmpty());
		assertEquals(false, queue.isFull());
	}
	
	@Test(expected = AssertionError.class)
	public void testQueueStatus2() throws Exception	{
		Queue queue = new Queue(3);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.dequeue();
		
		assertEquals(true, queue.isEmpty());
		assertEquals(false, queue.isFull());
	}	
	
	@Test(expected = AssertionError.class)
	public void testQueueStatus3() throws Exception	{
		Queue queue = new Queue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
	}
	
	@Test(expected = AssertionError.class)
	public void testQueueStatus4() throws Exception	{
		Queue queue = new Queue(10);
		queue.dequeue();
	}

}