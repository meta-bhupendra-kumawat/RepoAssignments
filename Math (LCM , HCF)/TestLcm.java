import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLcm {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 30, 33 , 330}, { 160, 30 , 480}, { 450, 150, 450 }, { 0, 0, 0}
                 });
    }

    private int fx;
    private int fy;
    private int fExpected;

    public TestLcm(int x, int y, int expected) {
        this.fx = x;
        this.fy = y;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on method lcm().
    @Test
	public void test() {
		assertEquals(fExpected, new MathOperations().lcm(fx, fy));
	}
}