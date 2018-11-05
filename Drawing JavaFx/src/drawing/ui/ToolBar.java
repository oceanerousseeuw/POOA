package drawing.ui;

import drawing.handlers.DeleteButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ToolBar {

    private Button clearButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button triangleButton;
    private Button deleteButton;
    
	public ToolBar(DrawingPane drawingPane) {
		clearButton = new Button("Clear");
        clearButton.setOnAction(event -> drawingPane.clear());
        rectangleButton = new Button("Rectangle");
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
        circleButton = new Button("Circle");
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
        
        triangleButton = new Button("Triangle");
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));
        
        deleteButton = new Button("Delete");
        deleteButton.addEventFilter(ActionEvent.ACTION, new DeleteButtonHandler(drawingPane));
	}

	public Button getClearButton() {
		return clearButton;
	}

	public void setClearButton(Button clearButton) {
		this.clearButton = clearButton;
	}

	public Button getRectangleButton() {
		return rectangleButton;
	}

	public void setRectangleButton(Button rectangleButton) {
		this.rectangleButton = rectangleButton;
	}

	public Button getCircleButton() {
		return circleButton;
	}

	public void setCircleButton(Button circleButton) {
		this.circleButton = circleButton;
	}

	public Button getTriangleButton() {
		return triangleButton;
	}

	public void setTriangleButton(Button triangleButton) {
		this.triangleButton = triangleButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(Button deleteButton) {
		this.deleteButton = deleteButton;
	}
	
}
