import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestBinarySearch {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 0, 0}, { new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 8, 8}, 
                 { new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 15, -1 }, { new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, -4, -1},
                 { new int[] { }, 2, -1}
                 });
    }

    private int fx[];
    private int fy;
    private int fExpected;

    public TestBinarySearch(int x[], int y, int expected) {
        this.fx = x;
        this.fy = y;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on method binarySearch().
    @Test
	public void test() {
		assertEquals(fExpected, new Search().binarySearch(fx, fy));
	}
}