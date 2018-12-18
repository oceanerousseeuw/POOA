package drawing.ui;

import java.util.List;

import drawing.handlers.DeleteButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.GroupButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import drawing.handlers.UngroupButtonHandler;
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
    private Button groupButton;
    private Button ungroupButton;
    
    
	public ToolBar(DrawingPane drawingPane) {
		
		ButtonFactory buttonFactory = new ButtonFactory();
		
		clearButton = buttonFactory.createButton("clear", false);
        clearButton.setOnAction(event -> drawingPane.clear());
        
        rectangleButton = buttonFactory.createButton("rectangle", true);
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
        
        circleButton = buttonFactory.createButton("circle", true);
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
        
        triangleButton = buttonFactory.createButton("triangle", true);
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));

        deleteButton = buttonFactory.createButton("delete", false);
        deleteButton.addEventFilter(ActionEvent.ACTION, new DeleteButtonHandler(drawingPane));
        
        groupButton = buttonFactory.createButton("group", false);
        groupButton.addEventFilter(ActionEvent.ACTION, new GroupButtonHandler(drawingPane));
        
        ungroupButton = buttonFactory.createButton("ungroup", false);
        ungroupButton.addEventFilter(ActionEvent.ACTION, new UngroupButtonHandler(drawingPane));
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

	public Button getGroupButton() {
		return groupButton;
	}

	public void setGroupButton(Button groupButton) {
		this.groupButton = groupButton;
	}

	public Button getUngroupButton() {
		return ungroupButton;
	}

	public void setUngroupButton(Button ungroupButton) {
		this.ungroupButton = ungroupButton;
	}
	
}
