import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* This is a component class.
 * This class is designed to manage employees.
 * @author Bhupendra
 */
public class ManageEmployees {
	Employee employee;
	List<Employee> empList = new ArrayList<Employee>();
	Set<String> empSet = new HashSet<String>();
	
	/* This method is used to  enroll new employees.
	 * @param empId
	 * @param name
	 * @param address
	 * @return true if an employee is added successfully, false otherwise.
	 */
	public boolean addEmployee(String empId, String name, String address) {
		
		// Checks for null pointer.
		if(empId == null || name == null || address == null)
			return false;
		
		// Resists to enter duplicate entries of empId.
		if(empSet.contains(empId)) {
			System.out.println("EmpId already exists.");
			throw new AssertionError("EmpId already exists.");
		}
		
		employee = new Employee(empId, name, address);
		empList.add(employee);
		empSet.add(employee.empId);
		return true;
	}
	
	// This method sorts the Employee according to their Employee Id.
	public void naturalSort() {
		empList.sort(new Compare());
	}
	
	// This method sorts the Employee according to their Employee Name.	
	public void sortByName() {
		empList.sort(new CompareName());
	}
	
	// This method prints the Employees.
	public void printEmployees() {
		for(Employee e : empList) {
			System.out.println(e.empId + "\t\t\t" + e.Name + "\t\t\t\t" + e.address);
		}
	}
}
