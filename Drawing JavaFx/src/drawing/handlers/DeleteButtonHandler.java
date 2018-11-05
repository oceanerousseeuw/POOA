package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DeleteButtonHandler implements EventHandler<Event> {

    private DrawingPane drawingPane;
    
	public DeleteButtonHandler(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }

	@Override
	public void handle(Event event) {
		
		if (event instanceof ActionEvent) {
            drawingPane.delete();
        }
	}


}
