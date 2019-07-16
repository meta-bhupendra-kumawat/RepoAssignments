
/*This is a component class.
 * This class consists of functions used to perform operations on strings like:
 * Reverse
 * Lower case to upper case character conversion and vice versa
 * Find the largest word in string.
 * @author Bhupendra
 */
public class OperateStrings {

	/* Compare two strings and returns 1 if both strings are equal, 0 otherwise.
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int equals(String s1, String s2)throws Exception {
		s1 = s1.trim();
		s2 = s2.trim();

		if (s1.length() != s2.length())
			return 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				return 0;
		}
		return 1;
	}

	/* Returns the reverse of given string.
	 * @param s
	 * @return
	 */
	public String reverse(String s)throws Exception {
		char sArray[] = s.toCharArray();
		for (int i = 0; i < s.length() / 2; i++) {
			char temp = sArray[i];
			sArray[i] = sArray[s.length() - 1 - i];
			sArray[s.length() - 1 - i] = temp;
		}
		return new String(sArray);
	}

	/* Converts the lower case to upper case and vice versa.
	 * @param s
	 * @return
	 */
	public String lowerUpper(String s)throws Exception {
		char sArray[] = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			int ch = sArray[i];
			if (ch >= 65 && ch <= 90)
				ch += 32;
			else {
				if (ch >= 97 && ch <= 122)
					ch -= 32;
			}

			sArray[i] = (char) ch;
		}
		return new String(sArray);
	}

	/* Returns largest word from given string.
	 * @param s
	 * @return largest String
	 */
	public String largestString(String s)throws Exception {
		char sArray[] = s.toCharArray();
		int maxBeginIndex = -1, maxEndIndex = -1, maxStrLen = 0, count = 0;
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			while ((i + count) < s.length() && sArray[j] != ' ') {
				count++;
				j++;
			}
			if (maxStrLen <= count) {
				maxStrLen = count;
				maxBeginIndex = i;
				maxEndIndex = i + count;
			}
			i = i + count;
			count = 0;
		}
		return s.substring(maxBeginIndex, maxEndIndex);
	}
}
