package ExpressionEvaluation;

/* This is an aplication class. This class uses the functionality of stack and Evaluates infix expressions.
 * @author Bhupendra.
 */
public class UseEvaluateInfix {

	/* This is a main method.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		EvaluateInfix ei = new EvaluateInfix();
		String str =//  "2 * 3 / ( 2 - 1 ) + 5 * 3"; 
		"(( 100 + 398 ) * 79 + 999 ) / 1000";
		
		System.out.println(EvaluateInfix.infixToPostfix(str));
		double s = ei.evaluatePostfix(str);
		System.out.println(s);
		
	}
	
}
