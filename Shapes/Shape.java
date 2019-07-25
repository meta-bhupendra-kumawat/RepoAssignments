
public interface Shape {
	public enum ShapeType{
		SQUARE,
		TRIANGLE,
		RECTANGLE,
		CIRCLE;
	}
	public int getArea();
	public int getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed();
}

//		https://stackoverflow.com/questions/24948924/how-to-return-an-object-from-enum-in-java/24948969
//						https://stackoverflow.com/questions/24948924/how-to-return-an-object-from-enum-in-java/24948969