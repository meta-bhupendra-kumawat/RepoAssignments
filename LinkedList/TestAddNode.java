import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAddNode {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, true },
                 { 2, true },
                 { 0, true },
                 { 2, true },
                 });
    }

    private int fInput;
    private boolean fExpected;

    public TestAddNode(int input, boolean expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on methods addNode().
    @Test
	public void test() {
    	assertEquals(fExpected, new LinkedList().addNode(fInput));
	}
}