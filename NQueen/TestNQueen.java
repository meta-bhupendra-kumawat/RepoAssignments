import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestNQueen {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{ 0 , true}, { -1 , false}, { 2 , false}, { 3 , false}, { 4 , true}, { 5 , true}, 
        		{ 6 , true}
                 });
    }

    private int fn;
    private boolean fExpected;

    public TestNQueen(int n, boolean expected) {
        this.fn = n;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on method lcm().
    @Test
	public void test() {
    	if(fn < 0){
    		System.out.println("Size can't be negative!!");
    		return;
    	}
    	int fx[][] = new int[fn][fn];
		assertEquals(fExpected, new NQueenProblem().SolveNQueen(fx, 0, fn));
	}
}