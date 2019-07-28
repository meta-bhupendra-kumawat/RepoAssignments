import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* This is a component class. This class is design to create objects of different shapes based on user requirements.
 * @author Bhupendra
 */
public class Factory {

	// Creating Screen object.
	public static Screen scn = new Screen();
	
	
	/* This method creates shape object and places that shape on Screen.
	 * @return true if shape is successfully placed on screen, false otherwise;
	 */
	public static boolean createShape( ) {
		
		// Variables
		List<Integer> parameterList ;
		int xCoordinate;
		int yCoordinate;
		int temp1, temp2;
		String shapeType;
		
		// Scanner object for user input.
		Scanner sc = new Scanner(System.in);
		
		// Taking shape type as string.
		System.out.println("Enter shape type to add : ");
		shapeType = sc.next();
		shapeType = shapeType.toUpperCase();
		
		// Taking origin coordinate from user and creating point object.
		System.out.print("Enter start point coordinates:\n x : ");
		xCoordinate = sc.nextInt();
		System.out.print(" y : ");
		yCoordinate = sc.nextInt();
		
		// Creating Point object.
		Point startPoint = new Point(xCoordinate, yCoordinate);
		
		switch(shapeType){
		
		// Creating object of shape Circle.
		case "CIRCLE" :
			parameterList = new ArrayList<Integer>();
			System.out.println("Enter radius of Circle : ");
			temp1 = sc.nextInt();
			parameterList.add(temp1);
			Circle c = new Circle(startPoint , parameterList);
			scn.addShape(c);
			break;
			
		// Creating object of shape Square.
		case "SQUARE":
			parameterList = new ArrayList<Integer>();
			System.out.println("Enter width of Square : ");
			temp1 = sc.nextInt();
			parameterList.add(temp1);
			Square sq = new Square(startPoint , parameterList);
			scn.addShape(sq);
			break;
			
		// Creating object of shape Triangle.
		case "TRIANGLE":
			parameterList = new ArrayList<Integer>();
			System.out.println("Enter side of Triangle : ");
			temp1 = sc.nextInt();
			parameterList.add(temp1);
			Triangle tr = new Triangle(startPoint , parameterList);
			scn.addShape(tr);
			break;
		
		// Creating object of shape Rectangle.
		case "RECTANGLE":
			parameterList = new ArrayList<Integer>();
			System.out.println("Enter Length of Rectangle : ");
			temp1 = sc.nextInt();
			System.out.println("Enter Width of Rectangle : ");
			temp2 = sc.nextInt();
			parameterList.add(temp1);
			parameterList.add(temp2);
			Rectangle rect = new Rectangle(startPoint , parameterList);
			scn.addShape(rect);
			break;
			
		case "POLYGON":
			break;
			
			default:
				System.out.println("Invalid Shape name.");
		}
		return true;
	}
	
	/* This method is used to sort shapes on screen according to user requirements.
	 * Sorting can be done based on Area, Perimeter, Distance from origin & Timestamp. 
	 */
	public static void sortShapes() {
		
		// Scanner object for user input.
		Scanner sc = new Scanner(System.in);
		
		// To display sorting options.
		System.out.println("Enter sort method : ");
		System.out.print("'AREA' to sort by area.\n"
				+ "'PERIMETER to sort by Perimeter.\n"
				+ "'DISTANCE' to sort by distance from origin.\n"
				+ "'TIMESTAMP' to sort on basis of TimeStamp.\n"
				+ "Enter Input : ");
		
		String input = sc.next();
		input = input.toUpperCase();
		
		switch(input) {
		
		// To sort shapes in ascending order of Area.
		case "AREA" :
			Factory.scn.sortByArea();
			break;
		
		// To sort shapes in ascending order of Perimeter.	
		case "PERIMETER" :
			Factory.scn.sortByPerimeter();
			break;
			
		// To sort shapes in ascending order of Distance from origin.	
		case "DISTANCE" :
			Factory.scn.sortByDistanceFromOrigin();
			break;
		
		// To sort shapes in ascending order of Timestamp.
		case "TIMESTAMP":
			Factory.scn.sortByTimestamp();
			break;
		
		// For invalid input.
		default :
				System.out.println("INVALID INPUT:");
		}
		
		// To print shapes in selected order.
		Factory.scn.show();
	}
}
