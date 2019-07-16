
/* This is a component class.
 * It consists of methods to calculate area of:
 * Triangle
 * Rectangle
 * Square
 * Circle
 * @author Bhupendra
 */
public class Area {
	
	/* Returns Area Of Triangle.
	 * @param width
	 * @param height
	 * @return area of triangle
	 * @throws ArithmeticException
	 */
	public double areaOfTriangle(double width, double height) throws ArithmeticException
	{
		double area = 0.5 * width * height;
		area = Area.roundOff(area);
		return area;
	}
	
	/* Returns Area Of Rectangle.
	 * @param width
	 * @param height
	 * @return area of rectangle
	 * @throws ArithmeticException
	 */
	public double areaOfRectangle(double width, double height) throws ArithmeticException
	{
		double area = width * height;
		area = Area.roundOff(area);
		return area;
	}
	
	/* Returns Area Of Square.
	 * @param width
	 * @return area of square
	 * @throws ArithmeticException
	 */
	public double areaOfSquare(double width) throws ArithmeticException
	{
		double area = 0.5 * Math.pow(width, 2);
		area = Area.roundOff(area);
		return area;
	}
	
	/* Returns Area Of Circle.
	 * @param radius
	 * @return area of circle
	 * @throws ArithmeticException
	 */
	public double areaOfCircle(double radius) throws ArithmeticException
	{
		double area = Math.PI * Math.pow(radius, 2);
		area = Area.roundOff(area);
		return area;
	}
	
	/* Returns round of a number upto 2 decimal places.
	 * @param n
	 * @return rounded off upto 2 digits
	 */
	public static double roundOff(double n)
	{
		n = (double) Math.round(n * 100) / 100;
		return n;
	}
}
