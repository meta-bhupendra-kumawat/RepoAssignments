import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestDetectLoop {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { true },
                 });
    }

    private boolean fExpected;

    public TestDetectLoop(boolean expected) {
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on methods detectLoop().
    @Test
	public void test() {
    	LinkedList list = new LinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(8);
		list.addNode(9);
		list.head.next.next.next.next.next = list.head.next.next;
    	assertEquals(fExpected, list.detectLoop());
    	System.out.println();
	}
}