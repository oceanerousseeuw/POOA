package drawing.handlers;

import java.util.Iterator;
import java.util.List;

import drawing.commands.ICommand;
import drawing.commands.MoveCommand;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    private List<IShape> selectedShapes;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMousePressed(this);
        drawingPane.setOnMouseDragged(this);
        drawingPane.setOnMouseReleased(this);
    }

    @Override
    public void handle(MouseEvent event) {
    	
        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
        	        	
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            

            Iterator it = drawingPane.iterator();
            while(it.hasNext()) {
            	IShape shape = (IShape) it.next();
                if (shape.isOn(event.getX(), event.getY())) {
                    selectedShapes = drawingPane.getSelection();
                    break;
                }
            }
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            if (selectedShapes == null)
                return;
            
            // on repere les x et y d'arrivée
            // on les envoie à offset
            orgTranslateX = event.getSceneX();
            orgTranslateY = event.getSceneY();
            
            double difOriDestX = orgTranslateX - orgSceneX;
            double difOriDestY = orgTranslateY - orgSceneY;
            
            boolean onSelectedShape = false;

            for(IShape selectedShape : selectedShapes) {
            	if (selectedShape.isOn(event.getX(), event.getY())) {
            		onSelectedShape = true;
            	}
            }
            
            if (onSelectedShape) {
            	ICommand command = new MoveCommand(drawingPane, difOriDestX, difOriDestY);
            	command.execute();
            }
            
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();

        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            	selectedShapes = null;
        }
    }
}
