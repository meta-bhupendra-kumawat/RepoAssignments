package ExpressionEvaluation;

import static org.junit.Assert.*;
import org.junit.Test;

/* This class consists of test cases for testing the method of the class EvaluateExpression.
 * @author Bhupendra
 */
public class TestEvaluateExpression {
	
	@Test
	public void testConversion()
	{
		String infixExpression = "(( 100 + 398 ) * 79 + 999 ) / 1000";
		String postfixExpression = EvaluateInfix.infixToPostfix(infixExpression);
		String expectedPostfixExpression = " 100  398 +  79 * 999 +  1000 /";
		assertEquals(expectedPostfixExpression, postfixExpression);
	}

	@Test
	public void testEvaluation() throws Exception
	{
		String infixExpression = "(( 100 + 398 ) * 79 + 999 ) / 1000";
		EvaluateInfix evaluationObject = new EvaluateInfix();
		assertEquals(40.341, evaluationObject.evaluatePostfix(infixExpression), 0.001);
	}
}