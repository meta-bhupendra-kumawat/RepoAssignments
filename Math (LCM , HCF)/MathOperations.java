
/* This is a component class.
 * This class consists of methods to calculate HCF and LCM of two given numbers.
 * The methods uses recursive approach for problem solving.
 * @author Bhupendra
 */
public class MathOperations {
	
	/* This method uses Euclidean algorithm for finding HCF of two given numbers.
	 * This method uses recursive approach for findings HCF.
	 * @param x number
	 * @param y number
	 * @return Highest Common Factor of given arguments x & y;
	 */
	public int hcfEuclidean(int x, int y)
	{
		int gcd;
		if(x == 0 || y ==0)
			return x+y;
		gcd = hcfEuclidean(y, x % y);
		return gcd;
	}
	
	/* This method calculates the LCM of two numbers given as arguments.
	 * This method uses recursive approach for finding LCM.
	 * @param x number
	 * @param y number
	 * @return Lowest Common Multiple of given arguments x & y.
	 */
	public int lcm(int x, int y)
	{
		if(x == 0 && y == 0)
			throw new AssertionError("All input numbers are zero.");
		int lcm = (x * y) / hcfEuclidean(x,y) ;		
		return lcm;
	}

}
