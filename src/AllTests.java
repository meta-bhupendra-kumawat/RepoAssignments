import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/* This is a JUnit Suite.
 * This class combinely runs all the test cases of different functions.
 * @author Bhupendra
 */
@RunWith(Suite.class)
@SuiteClasses({ TestArrCountClumps.class, TestArrFixXY.class, TestArrMaxMirror.class, TestSplitArray.class })
public class AllTests {

}
