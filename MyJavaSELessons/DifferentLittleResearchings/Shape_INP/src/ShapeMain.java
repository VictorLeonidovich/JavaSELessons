import java.util.Arrays;
import java.util.List;

public class ShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Shape> shapeList= Arrays.asList(new Circle(), new Square(), new Triangle());
		for (Shape shape : shapeList) {
			shape.draw();
		}

	}

}
