
/* This is a Application class. This class is used to maintain LinkedList of Employees.
 * @author Bhupendra
 */
public class UseLinkedList {
	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		l.addNode(new Employee("1", "AAAA", 24, 19000));
		l.addNode(new Employee("2", "BBBB", 23, 23000));
		l.addNode(new Employee("3", "CCC", 24, 69000));
		l.addNode(new Employee("4", "DDDD", 55, 91000));
		l.addNode(new Employee("5", "EEEE", 21, 29000));
		l.addNode(new Employee("6", "FFFF", 22, 29000));
		l.addNode(new Employee("7", "gggg", 18, 29000));
		l.addNode(new Employee("8", "HHHH", 20, 19000));
		l.addNode(new Employee("9", "IIII", 50, 91000));
		l.addNode(new Employee("10", "JJJJ", 57, 92000));
		l.show();
		System.out.println("\n\n\nSorted>>>>\n");
		
		// Sorting the employees based on salary.
		l.sortSalary();
		l.show();
	}

}
