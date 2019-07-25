
public class Circle {
	Point centre;
	int radius;
	int area;
	int perimeter;

	public Circle() {
	}
	
	public int getArea() {
		perimeter =  2 * (int)Math.PI * radius;
		return 0;
	}
	
	public int getPerimeter() {
		area = (int)Math.PI * radius * radius;
		return 0;
	}
	
	public Point getOrigin() {
		return centre;
	}
	
	public boolean isPointEnclosed() {
		return false;
	}
}
