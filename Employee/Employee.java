
/* This is a component class. It contains the attributes of Employee.
 * @author Bhupendra
 */
public class Employee {
	
	// Instance variables.
	static int counter = 1;
	String empId;
	String Name;
	String address;
	
	// Constructor.
	public Employee(String empId, String name, String address) {
		this.empId = empId;
		this.Name = name;
		this.address = address;
	}
}
