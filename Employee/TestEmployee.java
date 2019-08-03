import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEmployee {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "1", "Ranveer", "C-scheme", true },
                 { "2", "Deepika", "Bandra", true },
                 { "3", "Alia", "Worli", true },
                 { "4", "Ranbir", "SantaCruz", true },
                 { "5", "Nawazn", "RamGanj", true },
                 });
    }

    private String fEmpId;
    private String fName;
    private String fAddress;
    private boolean fExpected;

    public TestEmployee(String empId, String name, String address, boolean expected) {
        this.fEmpId = empId;
        this.fName = name;
        this.fAddress = address;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on methods addEmployee().
    @Test
	public void test() {
    	assertEquals(fExpected, new ManageEmployees().addEmployee(fEmpId, fName, fAddress));
	}
}
