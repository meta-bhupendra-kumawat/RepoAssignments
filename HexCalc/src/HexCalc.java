import java.util.*;

/* This a component class for Job Scheduler.
 * It consists of functions used for calculating Execution time, Turn Around 
 * time & Job Completion time.
 */
public class HexCalc implements Calc {

	static int base = 16;
	char hexArray[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
			'B', 'C', 'D', 'E', 'F' };

	// Map to store Decimal numbers as Key and Hexadecimal numbers as Value.
	static Map<Integer, Character> dec = new HashMap<>();

	// Map to store Hexadecimal numbers as Key and Decimal numbers as Value.
	static Map<Character, Integer> hex = new HashMap<>();

	// Block which copies the key value pairs into maps from hexArray.
	{
		for (int i = 0; i < base; i++) {
			dec.put(i, hexArray[i]);
			hex.put(hexArray[i], i);
		}
	}

	/* Adds two Hexadecimal Numbers.
	 * @param hex1 
	 * @param hex2
	 * @return
	 */
	@Override
	public String add(String hex1, String hex2) {
		long decimal1 = HexCalc.hexadecimalToDecimal(hex1);
		long decimal2 = HexCalc.hexadecimalToDecimal(hex2);
		if( decimal1 == -1 || decimal2 == -1)
			return "Invalid Operation";
		
		long sum = decimal1 + decimal2;
		String result = HexCalc.decimalToHexadecimal(sum);
		return result;
	}

	/* Subtracts two Hexadecimal Numbers.
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	@Override
	public String subtract(String hex1, String hex2) {
		long decimal1 = HexCalc.hexadecimalToDecimal(hex1);
		long decimal2 = HexCalc.hexadecimalToDecimal(hex2);
		if( decimal1 == -1 || decimal2 == -1)
			return "Invalid Operation";
		
		long diff = Math.abs(decimal1 - decimal2);
		String result = HexCalc.decimalToHexadecimal(diff);
		return result;
	}

	/* Multiplies two Hexadecimal Numbers.
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	@Override
	public String multiply(String hex1, String hex2) {
		long decimal1 = HexCalc.hexadecimalToDecimal(hex1);
		long decimal2 = HexCalc.hexadecimalToDecimal(hex2);
		if( decimal1 == -1 || decimal2 == -1)
			return "Invalid Operation";
		
		long sum = decimal1 * decimal2;
		String result = HexCalc.decimalToHexadecimal(sum);
		return result;
	}

	/* Divides and computes the quotient of two Hexadecimal Numbers.
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	@Override
	public String divide(String hex1, String hex2) {
		long decimal1 = HexCalc.hexadecimalToDecimal(hex1);
		long decimal2 = HexCalc.hexadecimalToDecimal(hex2);
		if( decimal1 == -1 || decimal2 == -1)
			return "Invalid Operation";

		if (decimal2 == 0)								// After convertion  to decimal checks whether divisor is not zero.
			return "Can't divide by Zero!!";
		
		long quotient = decimal1 / decimal2;
		String result = HexCalc.decimalToHexadecimal(quotient);
		return result;
	}

	/* Checks whether the given arguement is a Headecimal number or not. Returns
	 * true if number is Hexadecimal, false otherwise.
	 * @param hexDeci
	 * @return
	 */
	public static boolean checkHexadecimal(String hexDeci) {
		hexDeci = hexDeci.toUpperCase();
		for (int i = 0; i < hexDeci.length(); i++) {
			if (!hex.containsKey((char) hexDeci.charAt(i))) {
				System.out.println("Input is not a HexaDecimal Number.");
				return false;
			}
		}
		return true;
	}

	/* Converts decimal number to Hexadecimal number.
	 * @param n
	 * @return
	 */
	public static String decimalToHexadecimal(long n) {
		String result = "";
		long index;
		while (n > 0) {
			index = n % base;
			result = dec.get((int) index) + "" + result;
			n = n / base;
		}
		return result;
	}

	/* Converts Hexadecimal number to Decimal number.
	 * @param hexDeci
	 * @return
	 */
	public static long hexadecimalToDecimal(String hexDeci) {
		if (!HexCalc.checkHexadecimal(hexDeci)) {
			return -1;
		}
		long decimalNo = 0;
		hexDeci = hexDeci.toUpperCase();

		for (int i = 0; i < hexDeci.length(); i++) {
			decimalNo = (long) (Math.pow(base, i) * hex.get(hexDeci
					.charAt(hexDeci.length() - 1 - i))) + decimalNo;
		}
		return decimalNo;
	}

	/* Removes leading zeros from the given String argument.
	 * @param str
	 * @return
	 */
	public static String removeLeadingZeros(String str) {
		int i = 0;
		// Counting leading zeros
		while (i < str.length() && str.charAt(i) == '0')
			i++;

		StringBuffer sb = new StringBuffer(str);
		sb.replace(0, i, ""); 							// remove leading zeros
		return sb.toString(); 							// return in String
	}

	/* Checks the equality of two given String arguments
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static boolean isEqual(String hex1, String hex2) {
		if (!(HexCalc.checkHexadecimal(hex1) && HexCalc.checkHexadecimal(hex2))) {
			System.out.println("Any of the input is not a HexaDecimal Number.");
			return false;
		}		
		hex1 = HexCalc.removeLeadingZeros(hex1);
		hex2 = HexCalc.removeLeadingZeros(hex2);
		return hex1.equalsIgnoreCase(hex2);
	}

	/* Return true if first argument i.e a Hexadecimal number is Greater than
	 * the second argument
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static boolean isGreater(String hex1, String hex2) {
		if (!(HexCalc.checkHexadecimal(hex1) && HexCalc.checkHexadecimal(hex2))) {
			System.out.println("Any of the input is not a HexaDecimal Number.");
			return false;
		}
		hex1 = HexCalc.removeLeadingZeros(hex1).toUpperCase();
		hex2 = HexCalc.removeLeadingZeros(hex2).toUpperCase();

		if (hex1.length() > hex2.length())
			return true;
		if (hex1.length() < hex2.length())
			return false;

		for (int i = 0; i < hex1.length(); i++) {
			if (hex.get(hex1.charAt(i)) > hex.get(hex2.charAt(i)))
				return true;
		}
		return false;
	}

	/* Return true if first argument i.e a Hexadecimal number is Smaller than
	 * the second argument.
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static boolean isSmaller(String hex1, String hex2) {
		return !HexCalc.isGreater(hex1, hex2);
	}
}
