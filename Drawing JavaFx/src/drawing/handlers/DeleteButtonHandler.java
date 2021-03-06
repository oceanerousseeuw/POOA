package drawing.handlers;

import drawing.commands.DeleteCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DeleteButtonHandler implements EventHandler<Event> {

    private DrawingPane drawingPane;
    
	public DeleteButtonHandler(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }

	@Override
	public void handle(Event event) {
		if (event instanceof ActionEvent) {
			ICommand command = new DeleteCommand(drawingPane);
			command.execute();
        }
	}


}
