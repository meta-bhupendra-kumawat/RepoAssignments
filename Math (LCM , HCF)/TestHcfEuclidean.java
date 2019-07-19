import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestHcfEuclidean {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 30, 50 , 10}, { 160, 30 , 10}, { 450, 150, 150 }, { 0, 0, 0}
                 });
    }

    private int fx;
    private int fy;
    private int fExpected;

    public TestHcfEuclidean(int x, int y, int expected) {
        this.fx = x;
        this.fy = y;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on method hcfEuclidean().
    @Test
	public void test() {
		assertEquals(fExpected, new MathOperations().hcfEuclidean(fx, fy));
	}
}