import java.util.Scanner;

/* This is an Application class.
 * This class uses the functionality of Area.class to calculate area.
 * @author Bhupendra
 *
 */
public class UseArea {

	public static void main(String[] args) throws ArithmeticException {

		// Area object to use its instance methods
		Area a = new Area();

		// Scanner object for user input at runtime
		Scanner sc = new Scanner(System.in);

		// Variables for user input
		int option;
		double width;
		double height;
		double radius;

		while (true) {
			System.out.println("\nSelect the option to find:-");
			System.out.println("1: Area of Triangle.");
			System.out.println("2: Area of Rectangle.");
			System.out.println("3: Area of Square.");
			System.out.println("4: Area of Circle.");
			System.out.println("5: Exit.");

			option = sc.nextInt(); // Taking user input

			switch (option) {

			// Area of Triangle.
			case 1:
				System.out.println("Enter width:");
				width = sc.nextDouble();
				System.out.println("Enter height:");
				height = sc.nextDouble();
				if (width < 0 || height < 0) {
					System.out.println("Invalid Input. Dimensions can't be negative.");
					break;
				}

				System.out.println("Area of Triangle: " + a.areaOfTriangle(width, height));
				break;

			// Area of Rectangle.
			case 2:
				System.out.println("Enter width:");
				width = sc.nextDouble();
				System.out.println("Enter height:");
				height = sc.nextDouble();
				if (width < 0 || height < 0) {
					System.out.println("Invalid Input. Dimensions can't be negative.");
					break;
				}
				System.out.println("Area of Rectangle: " + a.areaOfRectangle(width, height));
				break;

			// Area of Square.
			case 3:
				System.out.println("Enter width:");
				width = sc.nextDouble();
				if (width < 0) {
					System.out.println("Invalid Input. Dimensions can't be negative.");
					break;
				}
				System.out.println("Area of Square: " + a.areaOfSquare(width));
				break;

			// Area of Circle.
			case 4:
				System.out.println("Enter radius:");
				radius = sc.nextDouble();
				if (radius < 0) {
					System.out.println("Invalid Input. Dimensions can't be negative.");
					break;
				}
				System.out.println("Area of Circle: " + a.areaOfCircle(radius));
				break;

			// Return Percentage of Students Passed
			case 5:
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
