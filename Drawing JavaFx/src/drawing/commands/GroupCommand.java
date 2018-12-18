package drawing.commands;

import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class GroupCommand implements ICommand{

	private DrawingPane drawingPane;
	private DrawingPane drawingPaneCopy;
	private Group shapeGroup;
	
	public GroupCommand(DrawingPane drawingPane, Group shapeGroup){
		this.drawingPane = drawingPane; 
		this.shapeGroup = shapeGroup;
    }
	
	@Override
	public void execute() {
		drawingPaneCopy = new DrawingPane(this.drawingPane);

		for(IShape shape : drawingPane.getSelection()) {
			shapeGroup.addShapeInGroup(shape);
			this.removeShape(shape);
		}
		drawingPane.addShape(shapeGroup);    
	}
	

    public void removeShape(IShape shape) {
		drawingPane.getShapes().remove(shape);
		shape.removeShapeFromPane(drawingPane);
		drawingPane.notifyObservers();
    }

	@Override
	public void undo() {
		drawingPane = drawingPaneCopy;
	}

}
