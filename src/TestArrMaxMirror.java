import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestArrMaxMirror {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7 }, 
                 { new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2 }, 
                 { new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3 }, 
                 { new int[] { 1, 2, 1, 2, 3, 3, 4, 3, 3, 2, 1 }, 9},
                 { new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0,}, 9},
                 {new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, 1 },	// Single match
                 { new int[] { }, 0}								// Empty array
                 });
    }

    private int fInput[];
    private int fExpected;

    public TestArrMaxMirror(int input[], int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    
    /* This method is used to run test cases on methods maxMirror().
     */
    @Test
	public void test() {
		assertEquals(fExpected, new ArrOperation().maxMirror(fInput));
	}
}