
import java.util.Scanner;

/*This is a Application class.
 * Used to maintain grades of Students.
 * @author Admin
 *
 */
public class UseMarksheet {
	
	public static void main(String[] args) throws Exception {

		// Marksheet object to use its instance methods
		Marksheet ms = new Marksheet();

		ms.enroll("Aanshi", 99.88988f);
		ms.enroll("Shubham", 39.968f);
		ms.enroll("Deepesh", 70);
		ms.enroll("Bhupendra", 80);
		ms.enroll("Avneet", 33.8989f);
		

		// Variables for user input
		int option;
		String name;
		float grade;

		// Scanner object for user input at runtime
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n\n\nSelect the option to:-");
			System.out.println("1: Enroll new Student.");
			System.out.println("2: Return Average of all Grades.");
			System.out.println("3: Return Maximum of all Grades.");
			System.out.println("4: Return Minimum of all Grades.");
			System.out.println("5: Return Percentage of Students Passed.");
			System.out.println("6: Show all Student's Details.");
			System.out.println("7: Exit.");
			System.out.println("Enter Your Choice: ");
			option = sc.nextInt(); // Taking user input

			switch (option) {

			// Enroll new Student
			case 1:
				System.out.println("Enter Student's Name:"); 
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter Student's Grade:");
				grade = sc.nextFloat();
				ms.enroll(name, grade);
				break;

			// Return Average of all Grades
			case 2:
				System.out.println("Average of Grades: " + ms.average());
				break;

			// Return Maximum of all Grades
			case 3:
				System.out.println("Maximum Grade: " + ms.maximum());
				break;

			// Return Minimum of all Grades
			case 4:
				System.out.println("Minimum Grade: " + ms.minimum());
				break;

			// Return Percentage of Students Passed
			case 5:
				System.out.println("Passing Percentage: " + ms.passed());
				break;

			// Show all Student's Details
			case 6:
				ms.showStudents();
				break;

			// Terminate the program
			case 7:
				sc.close();
				System.exit(0);
				break;

			// Invalid input
			default:
				System.out.println("Invalid Input. Try again!");
			}
		}
	}

}
