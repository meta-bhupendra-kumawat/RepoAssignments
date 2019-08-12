package ExpressionEvaluation;

/* this is a component class. This class is an implementation of Stack data structure which follows FIFO.
 * This class provides full functionality of stack data structure and provides functions like push(), pop() & peek().
 * @author Bhupendra.
 */
public class Stack {
	// Instance variables.
	Node top;
	Node newNode;
	
	// Constructor.
	public Stack() {
		top = null;
	}
	
	/* This method push elements into stack.
	 * @param element to push.
	 * @return true if element is successfully pushed, false otherwise.
	 */
	public boolean push(String element) {
		newNode = new Node();
		
		if(element == null)
			return false;
		
		newNode.data = element;
		newNode.next = null;
		if(top == null)
			top = newNode;
		else{
			newNode.next = top;
			top = newNode;
		}
		return true;
	}
	
	/* This method ejects the top element from the stack.
	 * @return top element in stack as string.
	 */
	public String pop() {
		if( top == null) {
			System.out.println("Stack is empty");
			return null;
		}
		
		String s = top.data;
		top = top.next;
		return s;
	}
	
	/* This method returns the top element present in the stack.
	 * @return top element as string.
	 */
	public String peek() {
		if( top == null) {
			System.out.println("Stack is empty");
			return null;
		}
		String topElement = top.data;
		return topElement;
	}
	
	/* This method checks whether the stack is empty or not.
	 * @return true if stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return top == null;
	}
}
