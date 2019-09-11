package QuickSort;

/**
 * It is a class having attributes of an employee
 * @author Bhupendra.
 */
public class Employee {
	private String empName;
	private int age;
	private int salary;
	
	/**
	 * Parameterized constructor to initialize employee attributes.
	 * @param empName name of employee
	 * @param age age of employee
	 * @param salary salary of employee.
	 */
	public Employee(String empName, int age, int salary) {
		this.setEmpName(empName);
		this.setAge(age);
		this.setSalary(salary);
	}

	// Getters and setters.
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
}