import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestArrFixXY {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new int[]{2, 6, 3, 4, 5, 5, 4, 6 }, new int[]{ 2, 6, 3, 4, 5, 6, 4, 5}, 4, 5 }, 
                 { new int[]{ 1, 4, 1, 5, 5, 4, 1 }, new int[] { 1, 4, 5, 1, 1, 4, 5}, 4, 5 },
                 { new int[]{ 5, 4, 9, 4, 9, 5}, new int[] { 9, 4, 5, 4, 5, 9}, 4, 5 },
                 { new int[] {}, new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 2, 4 },	//When array is empty
                 { new int[] { 7, 1, 4, 9, 7, 4, 1 }, new int[]{ 0, 0, 0, 0, 0, 0, 0}, 6, 7 }, 	//Unequal numbers of X & Y
                 { new int[] { 4, 4, 5, 5, 5, 4, 1 }, new int[]{ 0, 0, 0, 0, 0, 0, 0}, 8, 1 },	//Two adjacent X values
                 { new int[] { 1, 9, 2, 3, 5, 3, 4 }, new int[]{ 0, 0, 0, 0, 0, 0, 0}, 5, 6 },	//X occurs at last index
                 });
    }

    private int fInput[];
    private int fExpected[];
    private int fx;
    private int fy;

    public TestArrFixXY(int input[], int expected[], int x, int y) {
        this.fInput = input;
        this.fExpected = expected;
        this.fx = x;
        this.fy = y;
    }
    
    /* This method is used to run test cases on methods fixXY().
     */
    @Test
	public void test() {
		assertArrayEquals(fExpected, new ArrOperation().fixXY(fx, fy, fInput));
	}
}