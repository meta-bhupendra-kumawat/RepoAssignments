package QuickSort;

/**
 * This is an application class used for sorting linked list of employees 
 * using quick sort algorithm.
 * @author Bhupendra
 */
public class UseQuickSort {

	public static void main(String[] args) {
		QuickSortLinkedList linkedlist = new QuickSortLinkedList();
		Employee employee1 = new Employee("Bhupendra",22,95000);
		Employee employee2 = new Employee("Ronak",22,320000);
		Employee employee3 = new Employee("Deepesh",22,25000);
		Employee employee4 = new Employee("Vinod",21,25000);
		linkedlist.add(employee1);
		linkedlist.add(employee2);
		linkedlist.add(employee3);
		linkedlist.add(employee4);
		
		linkedlist.showLinkedList(linkedlist.getHead(),linkedlist.getRear());
		linkedlist.quickSort(linkedlist.getHead(),linkedlist.getRear());
		linkedlist.showLinkedList(linkedlist.getHead(),linkedlist.getRear());
	}
}
