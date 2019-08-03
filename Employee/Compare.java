import java.util.Comparator;

/* This is a component class and implements Comparator interface.
 * @author Bhupendra
 */
public class Compare implements Comparator <Employee> {

	/* This method is used to compare two Employee objects.
	 * return -1, 0 or 1 to say if it is less than, equal, or greater to the other.
	 */
	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.empId.compareTo(emp2.empId);
	}
}

/* This is a component class and implements Comparator interface.
 * @author Bhupendra
 */
class CompareName implements Comparator <Employee> {

	/* This method is used to compare two Employee objects.
	 * return -1, 0 or 1 to say if it is less than, equal, or greater to the other.
	 */
	@Override
	public int compare(Employee emp1, Employee emp2) {
	
		return emp1.Name.compareTo(emp2.Name);
	}
}