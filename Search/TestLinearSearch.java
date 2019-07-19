import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLinearSearch {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new int[] { 0, 6, 2, 5, 4, 5, 6, 0, 8 }, 0, 0}, { new int[] { 0, 1, 6, 3, 4, 7, 6, 7, 8 }, 8, 8}, 
                 { new int[] { 0, 1, 12, 3, 24, 5, 16, 7, 8 }, 15, -1 }, { new int[] { 0, 11, 21, 3, 41, 5, 16, 71, 8 }, -4, -1},
                 { new int[] { }, 2, -1}
                 });
    }

    private int fx[];
    private int fy;
    private int fExpected;

    public TestLinearSearch(int x[], int y, int expected) {
        this.fx = x;
        this.fy = y;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on method linearSearch().
    @Test
	public void test() {
		assertEquals(fExpected, new Search().linearSearch(fx, fy));
	}
}