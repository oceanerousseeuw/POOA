package drawing.handlers;

import java.util.List;

import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class GroupButtonHandler implements EventHandler<Event> {

	private DrawingPane drawingPane;
	
	public GroupButtonHandler(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }
	
	@Override
	public void handle(Event event) {
		if (event instanceof ActionEvent) {
			Group shapeGroup = new Group();
			for(IShape shape : drawingPane.getSelection()) {
				shapeGroup.addShapeInGroup(shape);
				drawingPane.removeShape(shape);
			}
			drawingPane.addShape(shapeGroup);    
		}
		
	}
	
	


	

}
