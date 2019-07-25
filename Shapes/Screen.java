import java.util.ArrayList;
import java.util.List;


public class Screen {

	public Screen() {
		
	}
	
	List<Shape> shapeList = new ArrayList<Shape>();
	
	public boolean addShape(Shape s) {
		shapeList.add(s);
		return false;
	}

	public boolean deleteShapes(String shapeType) {
		for(Shape s1 : shapeList) {
			if(shapeType == null)					// Add shape type
				shapeList.remove(s1);
		}
		return false;
	}
	
	public boolean deleteAllShapes() {
		shapeList.clear();
		return true;
	}
	
	public void distanceFromOrigin(Shape s) {
		
	}
}
