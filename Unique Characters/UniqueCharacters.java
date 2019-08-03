import java.util.HashMap;
import java.util.Map;

/* This is a component class. It consists of method to count unique characters in given input string.
 * @author Bhupendra
 */
public class UniqueCharacters {

	// Map used for caching previous inputs with their outputs.
	private Map<String, Integer> cache = new HashMap<String, Integer>();
	
	/* This method counts unique characters in given input string.
	 * @param str input string.
	 * @return number of unique characters.
	 */
	public int noOfUnique(String str) {
		
		// Variables.
		int count = 0;
		
		// Temporary map used for checking unique characters.
		Map<String, Integer> tempHash = new HashMap<String, Integer>();
		
		if(str == null)
			return -1;
		str = str.trim().toUpperCase();
		if(cache.containsKey(str)) {
			System.out.print("Cached : ");
			return cache.get(str);
		}
		for(int i = 0; i < str.length(); i++) {
			if(tempHash.containsKey(str.charAt(i) + "")) {
				int countVal = tempHash.get(str.charAt(i) + "");
				tempHash.put(str.charAt(i) + "", countVal + 1);
				if(countVal == 1)
					count--;
				continue;
			}
			tempHash.put(str.charAt(i) + "", 1);
			count++;
		}
		cache.put(str, count);
		return count;
	}
}
