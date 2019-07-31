
/* This is a component class. It is an implementation of LinkedList data structure.
 * This class consists of methods for creating, rotating & detecting loop in LinkedList.
 * @author Bhupendra
 */
public class LinkedList {

	Node head;
	Node newNode;
	
	public boolean addNode(int a){
		newNode = new Node();
		newNode.data = a;
		newNode.next = null;
		
		if(head == null){
			head = newNode;
		}else{
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNode;
		}
		return true;		
	}
	
	/* This method splits the list from given l & r positions. The splitted sub-list is rotated by 
	 * n number of positions.
	 * @param l left position to split.
	 * @param r right position to split.
	 * @param n number if shifts
	 * @return true if sub list of list is shifted successfully, false otherwise.
	 */
	public boolean rotateSubList(int l, int r, int n) {
		
		if(l <= 0 || r > this.size() || this.head == null) {
			System.out.println("Left or right position out of bound!!");
			throw new AssertionError("Left or right position out of bound!!");
		}
		int count = 1;
		LinkedList subList = new LinkedList();
		subList.head = this.head;
		Node nodeBeforeL = this.head;			// Storing reference to node before "l" of original list.
		Node nodeAfterR = null;					// Storing reference to node after "r" of original list.
		Node temp = this.head;					// Temporary reference for traversal of linked-list.
		
		while(temp != null && count <= r) {
			if(count == l - 1) {
				nodeBeforeL = temp;
				subList.head = temp.next;
				nodeBeforeL.next = null;
			}
			if(count == r) {
				nodeAfterR = temp.next;
				temp.next = null;
			}
			temp = temp.next;
			count++;
		}
		
		// Roatating sub-list
		subList.rotateList(n);
		
		// Connecting sub-list to original list.
		if(l == 1)
			this.head = subList.head;
		else
			nodeBeforeL.next = subList.head;
		
		temp = subList.head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = nodeAfterR;
		return true;
	}
	
	/* This methods rotates the list elements by given number of positions.
	 * @param n number of shifts.
	 * @return true if list is rotated successfully, false otherwise.
	 */
	public boolean rotateList(int n) {
		if(this.head == null) {
			System.out.println("List has not been initialised!!");
			throw new AssertionError("List has not been initialised!!");
		}
		LinkedList list = this;
		Node temp = list.head;
		Node prev = null;
		int count = 0;

		while(temp.next != null & count < n) {
			while(temp.next != null) {
				prev = temp;
				temp = temp.next;	
			}
			temp.next = list.head;
			list.head = temp;
			prev.next = null;
			count++;
		}
		return true;
	}
	
	// This method prints the linked list.
	public void show() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}
	
	/* To method will find out the size of linked-list.
	 * @return size or number of nodes of linked-list.
	 */
	public int size() {
		int count = 1;
		Node temp = this.head;
		while(temp.next != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	/* This method checks for any loop present in linked-list.
	 * @return true if loop exists, false otherwise.
	 */
	public boolean detectLoop() {
		if(this.head == null) {
			System.out.println("List has not been initialised!!");
			throw new AssertionError("List has not been initialised!!");
		}
		Node slow = this.head;
		Node fast = this.head;
		do{
			System.out.println(fast.data+ " "+ slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}while(fast != null && slow != fast && fast.next != null);
		if(fast == slow)
			return true;
		
		return false;
	}
}
