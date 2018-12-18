package drawing.commands;

import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class MoveCommand implements ICommand{
	
	private DrawingPane drawingPane;
	private DrawingPane drawingPaneCopy;
	private double difOriDestX;
	private double difOriDestY;

    private List<IShape> selectedShapes;

	public MoveCommand(DrawingPane drawingPane, double difOriDestX, double difOriDestY){
		this.drawingPane = drawingPane; 
		this.difOriDestX = difOriDestX; 
		this.difOriDestY = difOriDestY;
    }
	@Override
	public void execute() {
		drawingPaneCopy = new DrawingPane(this.drawingPane);

        selectedShapes = drawingPane.getSelection();
        
        for(IShape selectedShape : selectedShapes) {
        	selectedShape.offset(difOriDestX, difOriDestY);
    	}
	}

	@Override
	public void undo() {
		drawingPane = drawingPaneCopy;
	}


}
