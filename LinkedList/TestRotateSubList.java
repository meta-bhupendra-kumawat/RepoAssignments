import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestRotateSubList {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, 5, 3, true },
                 { 2, 8, 20, true },
                 { 0, 0, 0, true },
                 { 2, 1, 3, true },
                 });
    }

    private int fInput1;
    private int fInput2;
    private int fInput3;
    private boolean fExpected;

    public TestRotateSubList(int input1, int input2, int input3, boolean expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fInput3 = input3;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on methods rotateSubList().
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
    	assertEquals(fExpected, list.rotateSubList(fInput1, fInput2, fInput3));
    	list.show();
    	System.out.println();
	}
}