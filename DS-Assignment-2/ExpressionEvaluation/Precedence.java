package ExpressionEvaluation;

import java.util.HashMap;
import java.util.Map;

/* This is a component class. This class defines the precedence of the given operand.
 * This class uses Map interface and HashMap for storing the precedence of the available operators.
 * @author Bhupendra.
 */
public class Precedence {
	
	// HashMap for storing symbols with their precendences as a key-value pair.
	public static Map<String, Integer> precedence = new HashMap<String, Integer>();
	
	// Static block.
	static {
		precedence.put("(", -11);
		precedence.put("=", 1);
		precedence.put("!=", 8);
		precedence.put("<", 9);
		precedence.put(">", 9);
		precedence.put("<=", 9);
		precedence.put(">=", 9);
		precedence.put("+", 11);
		precedence.put("-", 11);
		precedence.put("*", 12);
		precedence.put("/", 12);
		precedence.put("%", 12);
		precedence.put("&&", 4);
		precedence.put("||", 3);
		precedence.put("!", 14);
		}
}
