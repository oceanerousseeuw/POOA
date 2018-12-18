package drawing.shapes;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class Group implements IShape{

	private ArrayList<IShape> shapesInGroup;
	private IShape cursorShape;
	
	public Group() {
		shapesInGroup = new ArrayList();
	}
	
	public void addShapeInGroup(IShape shape) {
		shapesInGroup.add(shape);
	}
	
	public void removeShapeInGroup(IShape shape) {
		shapesInGroup.remove(shape);
	}

	@Override
	public void setSelected(boolean selected) {
		for(IShape shape : shapesInGroup) {
			shape.setSelected(selected);
		}
	}

	@Override
	public boolean isOn(double x, double y) {
		for(IShape shape : shapesInGroup) {
			if(shape.isOn(x, y)) {
				cursorShape = shape;
				return true;
			}
		}
		return false;
	}

	@Override
	public void offset(double x, double y) {
		for(IShape shape : shapesInGroup) {
			shape.offset(x, y);
		}
	}

	@Override
	public void addShapeToPane(Pane pane) {
		for(IShape shape : shapesInGroup) {
			shape.addShapeToPane(pane);
		}
	}

	@Override
	public void removeShapeFromPane(Pane pane) {
		for(IShape shape : shapesInGroup) {
			shape.removeShapeFromPane(pane);
		}
	}

	public ArrayList<IShape> getShapesInGroup() {
		return shapesInGroup;
	}

	public void setShapesInGroup(ArrayList<IShape> shapesInGroup) {
		this.shapesInGroup = shapesInGroup;
	}

	public IShape getCursorShape() {
		return cursorShape;
	}

	public void setCursorShape(IShape cursorShape) {
		this.cursorShape = cursorShape;
	}
	

}
