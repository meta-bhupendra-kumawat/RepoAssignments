import java.util.Scanner;

/*This is a Application class.
 * Used to perfom operations on the strings.
 * @author Admin
 *
 */
public class UseOperateString {

	public static void main(String[] args)throws Exception {

		// OperateString object to use its instance methods
		OperateStrings os = new OperateStrings();

		// Scanner object for user input at runtime
		Scanner sc = new Scanner(System.in);

		int option;
		String s1;
		String s2;

		while (true) {
			System.out.println("Enter your option: "
					+ "\n1.Compare two Strings" + "\n2.Reverse a String"
					+ "\n3.Convert the case of characters in String"
					+ "\n4.Print largest word in String" + "\n5.Exit");
			option = sc.nextInt();
			switch (option) {

			// Compare two Strings
			case 1:
				System.out.println("Enter two Strings");
				sc.nextLine();
				s1 = sc.nextLine();
				s2 = sc.nextLine();
				System.out.println(os.equals(s1, s2));
				break;

			// Reverse string
			case 2:
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter a String");
				s1 = sc1.nextLine();
				System.out.println(os.reverse(s1));
				break;

			// Return lower case into upper case and vice versa
			case 3:
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter a String");
				s1 = sc2.nextLine();
				System.out.println(os.lowerUpper(s1));
				break;

			// Print largest word in String
			case 4:
				System.out.println("Enter a String");
				Scanner sc3 = new Scanner(System.in);
				s1 = sc3.nextLine();
				System.out.println(os.largestString(s1));
				break;
				
			// To terminate the program
			case 5:
				sc.close();
				System.exit(0);

			// For invalid option input
			default:
				System.out.print("Invalid input");

			}

		}
	}

}
