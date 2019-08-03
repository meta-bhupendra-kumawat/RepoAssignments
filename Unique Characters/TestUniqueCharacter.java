import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestUniqueCharacter {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "Hello", 3}, { "CzechSlovakia", 9 }, { "America", 5}, { "MISSISSIPPI", 1}, {"IVVVINNAYI",2}, {"", 0}, {null , -1}
                 });
    }

    private String fx;
    private int fExpected;

    public TestUniqueCharacter(String str, int expected) {
        this.fx = str;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on method noOfUnique().
    @Test
	public void test() {
		assertEquals(fExpected, new UniqueCharacters().noOfUnique(fx));
	}
}