import java.util.*;

/* This is a component class.
 * This class consists of methods:
 * Calculate average grade
 * Calculate maximum of grades
 * Calculate minimum of grades
 * Calculate passing percentage of students
 * @author Bhupendra
 *
 */
public class Marksheet {
	
	//	Stores the object of Student and maintains the Student's list.
	List<Student> stList = new ArrayList<Student>();

	/* Enrolls the Students and store it in ArrayList.
	 * @param rollNo
	 * @param name
	 * @param grade
	 */
	void enroll(String name, float grade) {
		if (grade < 0.00f || grade > 100.00f) {
			System.out.println("Invalid Grade. Grade should be between 0 to 100.");
			return;
		}
		Student st = new Student(name, grade);
		stList.add(st);
	}

	/* Returns the average of the grade.
	 * @return
	 * @throws ArithmeticException
	 */
	public float average() throws ArithmeticException {
		float average = 0f;
		for (Student s : stList) {
			average = average + s.grade;
		}
		average = average / stList.size();
		average = Marksheet.roundOff(average);
		return average;
	}

	/* Returns maximum grade among the grades scored by Students.
	 * @return
	 */
	public float maximum() {
		float maximum = Float.NEGATIVE_INFINITY;
		for (Student s : stList) {
			if (maximum < s.grade)
				maximum = s.grade;
		}
		maximum = Marksheet.roundOff(maximum);
		return maximum;
	}

	/* Returns minimum grade among the grades scored by Students.
	 * @return
	 */
	public float minimum() {
		float minimum = Float.POSITIVE_INFINITY;
		for (Student s : stList) {
			if (minimum > s.grade)
				minimum = s.grade;
		}
		minimum = Marksheet.roundOff(minimum);
		return minimum;
	}

	/* Returns the percentage of Students passed and shows their details.
	 * @return
	 */
	public float passed() {
		float count = 0f;
		System.out.println("\n-----------STUDENTS PASSED-------------");
		System.out.println("Name \t\t\t\t Grade");
		System.out.println("----------------------------------------\n");
		for (Student s : stList) {
			if (s.grade >= 40) {
				count++;
				System.out.println(s.name + "  \t\t\t " + Marksheet.roundOff(s.grade));
			}
		}
		System.out.println("----------------------------------------\n");
		float percPassed = count / stList.size() * 100;
		percPassed = Marksheet.roundOff(percPassed); 
		return percPassed;
	}

	// Shows the details of the Students.
	public void showStudents() {
		System.out.println("\n--------------STUDENTS TABLE--------------");
		System.out.println("Name \t\t\t\t Grade");
		System.out.println("------------------------------------------");
		for (Student s : stList) {
			System.out.println(s.name + "  \t\t\t " + Marksheet.roundOff(s.grade));
		}
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------\n");
	}

	/* Returns rounded off value upto 2 decimal places.
	 * @param n
	 * @return float upto 2 decimal places.
	 */
	public static float roundOff(float n) {
		n = (float) Math.round(n * 100) / 100;
		return n;
	}

}
