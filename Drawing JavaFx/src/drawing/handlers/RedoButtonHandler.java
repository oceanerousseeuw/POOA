package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class RedoButtonHandler implements EventHandler<Event> {

    private DrawingPane drawingPane;
    
	public RedoButtonHandler(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }

	@Override
	public void handle(Event event) {
		
		if (event instanceof ActionEvent) {
			
        }
	}
}