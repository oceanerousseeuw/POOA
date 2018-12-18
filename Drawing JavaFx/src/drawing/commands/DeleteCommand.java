package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class DeleteCommand implements ICommand{
	
	private DrawingPane drawingPane;
    private ArrayList<IShape> deletedShapes;
	
	public DeleteCommand(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }
	
	@Override
	public void execute() {

		deletedShapes = new ArrayList();
		
    	List<IShape> selectedShapes = drawingPane.getSelection();
    	for (IShape shape : selectedShapes) {
    		deletedShapes.add(shape);
        	shape.removeShapeFromPane(drawingPane);
        	drawingPane.getShapes().remove(shape);
        }
    	drawingPane.getSelectionHandler().deleteSelectedShapes();
    	drawingPane.notifyObservers();
	}
	

    public void removeShape(IShape shape) {
    	drawingPane.getShapes().remove(shape);
		shape.removeShapeFromPane(drawingPane);
		drawingPane.notifyObservers();
    }

	@Override
	public void undo() {
		for(IShape shape : deletedShapes) {
			drawingPane.addShape(shape);
		}
	}

}
