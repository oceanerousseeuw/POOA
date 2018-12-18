package drawing.handlers;

import java.util.ArrayList;
import java.util.List;
import drawing.shapes.Group;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class UngroupButtonHandler implements EventHandler<Event> {

	private DrawingPane drawingPane;
	
	public UngroupButtonHandler(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }
	
	@Override
	public void handle(Event event) {
		if (event instanceof ActionEvent) {
			ArrayList<Group> shapeGroups = new ArrayList<>();
			for (IShape selectedShape : drawingPane.getSelection()) {
				if(selectedShape instanceof Group) {
					shapeGroups.add((Group) selectedShape);
				}
			}
			
			for(Group shapeGroup : shapeGroups) {
				IShape cursorShape = shapeGroup.getCursorShape();
				shapeGroup.setSelected(false);
				shapeGroup.removeShapeInGroup(cursorShape);
				drawingPane.removeShape(cursorShape);
				drawingPane.addShape(cursorShape);
			}    
		}
		
	}
	
	


	

}
