
public class Rectangle {

	Point p1;
	Point p2;
	Point p3;
	Point p4;
	Point start;
	Point centre;
	int length;
	int width;
	int area;
	int perimeter;

	public Rectangle() {
		area = this.getArea();
		perimeter = this.getPerimeter();
		center = this.getOrigin();
	}
	
	public int getArea() {
		area = length * width;
		return area;
	}
	
	public int getPerimeter() {
		perimeter = 2 * (length + width);
		return 0;
	}
	
	public Point getOrigin() {
		Point topRight = new Point(start.x + length, start.y + width );
		centre.x = (start.x + topRight.x) / 2;
		centre.y = (start.y + topRight.y) / 2;
		return centre;
	}
	
	public boolean isPointEnclosed() {
		return false;
	}

}
