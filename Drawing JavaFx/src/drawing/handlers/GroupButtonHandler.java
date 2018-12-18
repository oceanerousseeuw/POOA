package drawing.handlers;

import drawing.commands.GroupCommand;
import drawing.commands.ICommand;
import drawing.shapes.Group;
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
			ICommand command = new GroupCommand(drawingPane, shapeGroup);
			command.execute();
		}
		
	}
	
	


	

}
