package drawing.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape{

	Shape myShape;
	
	private boolean isSelected = false;
	
	public ShapeAdapter(Shape shape) {
		this.myShape = shape;
	}
	
	@Override
	public void addShapeToPane(Pane pane) {
		pane.getChildren().add(myShape);
	}

	@Override
	public boolean isSelected() {
		return isSelected;
	}

	@Override
	public void setSelected(boolean selected) {
		this.isSelected = selected;
		if(selected) {
			myShape.getStyleClass().add("selected");
		} else {
			myShape.getStyleClass().remove("selected");
		}
		
	}

	@Override
	public boolean isOn(double x, double y) {
		// retourne true si le point en x,y se trouve sur la forme
		if(myShape.getBoundsInParent().contains(x, y)) {
			return true;
		}
		return false;
	}

	@Override
	public void offset(double x, double y) {
		// permet de decaler la forme en x et y 
		myShape.setTranslateX(myShape.getTranslateX() + x);
		myShape.setTranslateY(myShape.getTranslateY() + y);
		
	}

	@Override
	public void removeShapeFromPane(Pane pane) {
		pane.getChildren().remove(myShape);
		
	}
}
