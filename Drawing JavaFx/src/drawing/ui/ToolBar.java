package drawing.ui;

import java.util.List;

import drawing.handlers.DeleteButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ToolBar {

    private Button clearButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button triangleButton;
    private Button deleteButton;
    
	public ToolBar(DrawingPane drawingPane) {
		
		ButtonFactory buttonFactory = new ButtonFactory();
		
		clearButton = buttonFactory.createButton("clear");
        clearButton.setOnAction(event -> drawingPane.clear());
        
        rectangleButton = buttonFactory.createButton("rectangle");
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
        
        circleButton = buttonFactory.createButton("circle");
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
        
        triangleButton = buttonFactory.createButton("triangle");
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));

        deleteButton = buttonFactory.createButton("delete");
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
