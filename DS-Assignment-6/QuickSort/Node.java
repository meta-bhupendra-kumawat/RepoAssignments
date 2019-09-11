package QuickSort;

/**
 * This is a component class.
 * @author Bhupendra.
 */
public class Node {
	private Employee data;
	private Node next = null;

	// Default constructor.
	public Node() {
	}

	/**
	 * Parameterized constructor.
	 * @param data value for the data field of node.
	 */
	public Node(Employee data) {
		this.setData(data);
		setNext(null);
	}

	// Getters and setters.
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Employee getData() {
		return data;
	}

	public void setData(Employee data) {
		this.data = data;
	}
}