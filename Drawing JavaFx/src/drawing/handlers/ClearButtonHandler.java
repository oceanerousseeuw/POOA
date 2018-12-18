package drawing.handlers;

import drawing.commands.ClearCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<Event> {

    private DrawingPane drawingPane;
    
	public ClearButtonHandler(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }

	@Override
	public void handle(Event event) {
		
		if (event instanceof ActionEvent) {
			ICommand command = new ClearCommand(drawingPane);
			command.execute();
        }
	}
}
