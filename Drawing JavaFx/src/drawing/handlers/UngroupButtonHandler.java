package drawing.handlers;

import java.util.ArrayList;

import drawing.commands.ICommand;
import drawing.commands.UngroupCommand;
import drawing.shapes.Group;

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
			ICommand command = new UngroupCommand(drawingPane, shapeGroups);
			command.execute();
		}
		
	}
	
	


	

}
