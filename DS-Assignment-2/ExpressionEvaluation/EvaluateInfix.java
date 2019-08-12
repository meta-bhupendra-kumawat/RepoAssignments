package ExpressionEvaluation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/* This is a component class. This class is implemented for evaluating mathematical expressions.
 * This class consists of method for manipulating expression from infix to postfix.
 * @author Bhupendra
 */
public class EvaluateInfix {
	
	/* This is a static method. This method converts the given expression to postfix.
	 * @param expression.
	 * @return postfix expression.
	 */
	public static String infixToPostfix(String expression) {
		Stack stk = new Stack();
		String postfix = "";
		for(int i = 0; i < expression.length(); i ++) {
			
			if(expression.charAt(i) == ' ') {
				postfix = postfix.concat(" ");
				continue;
			}
			if(expression.charAt(i) == ')') {
				while(!stk.peek().equals("(")) {
					postfix = postfix.concat(stk.pop());
				}
				stk.pop();
				continue;
			}
			
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				
				int j = 0;
				String strBase = "";
				while( (i+j) < expression.length() && EvaluateInfix.isNumber(expression.charAt(i + j)) ) {
					strBase =  strBase.concat(expression.charAt(i + j) + "");
					j++;
				}
				postfix = postfix.concat( strBase + "" );	
				i = i + j - 1;
				continue;
			}
			
			if(Precedence.precedence.containsKey(expression.charAt(i)+"") || expression.charAt(i) == '(') {
				if(stk.isEmpty() || expression.charAt(i) == '(' || stk.peek().equals("(")) {
					stk.push(expression.charAt(i)+"");
					continue;
				}
				
				if(Precedence.precedence.get(expression.charAt(i)+"") > Precedence.precedence.get(stk.peek()))
					stk.push(expression.charAt(i) + "");
				else{
					while( (!stk.isEmpty()) && Precedence.precedence.get(expression.charAt(i)+"") <= Precedence.precedence.get(stk.peek())) 
						postfix = postfix.concat(stk.pop());
					stk.push(expression.charAt(i) + "");
				}
				continue;
			}
		}
		while(!stk.isEmpty())
			postfix = postfix.concat(" " + stk.pop());
		return postfix;
	}
	
	/* This method evaluates the given postfix expression with the given precedence.
	 * @param expression to evaluate.
	 * @return value by solving the expression.
	 * @throws Exception
	 */
	public double evaluatePostfix(String expression) throws Exception {
		
		expression = EvaluateInfix.infixToPostfix(expression);
		Stack stack = new Stack();
		for( int i = 0; i < expression.length(); i++ ) {
			
			if(expression.charAt(i) == ' ') {
				continue;
			}
			
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				int j = 0;
				String strBase = "";
				while( (i+j) < expression.length() && EvaluateInfix.isNumber(expression.charAt(i + j)) ) {
					strBase =  strBase.concat(expression.charAt(i + j) + "");
					j++;
				}
				i = i + j - 1;
				stack.push(strBase);
				continue;
			}
			
			if(Precedence.precedence.containsKey(expression.charAt(i)+"")) {
				
				// Using ScriptManager of JavaScript for directly evaluating an expression of string type.
				ScriptEngineManager mgr = new ScriptEngineManager();
			    ScriptEngine engine = mgr.getEngineByName("JavaScript");
			    
			    // Popping first two elements from stack as operands.
			    String b = stack.pop();
				String a = stack.pop();
				String operation = a + " " + expression.charAt(i) + " " + b;
				String s = engine.eval(operation) + "";	
				stack.push(s);
			}
		}
		return Double.parseDouble(stack.peek());
	}
	
	/* This method checks for the given character is a number or not. It compares the ASCII value for checking.
	 * @param s character.
	 * @return true if the given parameter is a number, false otherwise.
	 */
	public static boolean isNumber(char s) {
		return (s >= 48 && s <= 57);
	}
}
