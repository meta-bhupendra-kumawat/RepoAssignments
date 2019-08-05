
/* This is a component class. It is an implementation of LinkedList of Employees
 * using LinkedList data structure.
 * This class consists of methods for creating & sorting(descending) LinkedList 
 * of Employees based on their salaries and age.
 * @author Bhupendra.
 */
public class LinkedList {

	private Node head;
	private Node newNode;
	
	public boolean addNode(Employee e){
		newNode = new Node();
		newNode.data = e;
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

	// This method prints the linked list.
	public void show() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data.Name + "\t->\t" + temp.data.salary + 
					"  \t->\t" + temp.data.age);
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

	/* This method sort (descending) based on their salary, the one having the highest salary will be the 1st and 
	 * the one having the lowest will be the last.
	 * For sorting insertion sort is used.
	 */
	public void sortSalary() {
		
		// Temporary references used for sorting.
		Node temp = this.head;
		Node prev = this.head;
		
		// Runs until the list ends and all the elements in lists are sorted.
		while(temp != null) {
			
			// Temporary references.
			Node ref2 = this.head;				// Reference #2
			Node prevRef2 = this.head;			// Reference preceding ref2.
			
			// Until the salary of current element is greater than the previous elements.
			while(ref2 != temp && temp.data.salary < ref2.data.salary) {
				prevRef2 = ref2;
				ref2 = ref2.next;
			}
			
			// If the list before temp is sorted, then move temp to next node.
			if(ref2 == temp) {
				prev = temp;
				temp = temp.next;
				continue;
			}
			
			// When salary of two employees are equal.
			if(temp.data.salary == ref2.data.salary) {
				
				// Check for age.
				if(ref2.data.age < temp.data.age) {
					prev.next = temp.next;
					temp.next = ref2.next;
					ref2.next = temp;
				} else {
					prev.next = temp.next;
					if(head == ref2)
						head = temp;
					else
						prevRef2.next = temp;
					temp.next = ref2;
				}
				temp = prev;
			}
			
			// If salary of current element is greater than the previous one.
			if(temp.data.salary > ref2.data.salary) {
				
				prev.next = temp.next;
				temp.next = ref2;
				if(head == ref2)
					head = temp;
				else
					prevRef2.next = temp;
				temp = prev;						
			}
			
			// Traverse further.
			prev = temp;
			temp = temp.next;
		}
	}
}
