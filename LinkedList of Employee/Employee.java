
/* This is a component class. It contains the attributes of Employee.
 * @author Bhupendra
 */
public class Employee {
	
	// Instance variables.
	static int counter = 1;
	String empId;
	String Name;
	int age;
	double salary;
	
	// Constructor.
	public Employee(String empId, String name, int age, double salary) {
		this.empId = empId;
		this.Name = name;
		this.age = age;
		this.salary = salary;
	}
}
