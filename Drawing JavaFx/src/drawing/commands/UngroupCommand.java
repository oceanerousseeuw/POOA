package drawing.commands;

import java.util.ArrayList;

import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class UngroupCommand implements ICommand{
	
	private DrawingPane drawingPane;
	private DrawingPane drawingPaneCopy;
	private ArrayList<Group> shapeGroups;
	
	public UngroupCommand(DrawingPane drawingPane, ArrayList<Group> shapeGroups){
		this.drawingPane = drawingPane; 
		this.shapeGroups = shapeGroups;
    }
	
	@Override
	public void execute() {
		drawingPaneCopy = new DrawingPane(this.drawingPane);

		for (IShape selectedShape : drawingPane.getSelection()) {
			if(selectedShape instanceof Group) {
				shapeGroups.add((Group) selectedShape);
			}
		}
		
		for(Group shapeGroup : shapeGroups) {
			IShape cursorShape = shapeGroup.getCursorShape();
			shapeGroup.setSelected(false);
			shapeGroup.removeShapeInGroup(cursorShape);
			drawingPane.removeShape(cursorShape);
			drawingPane.addShape(cursorShape);
		}  
	}

	@Override
	public void undo() {
		drawingPane = drawingPaneCopy;
	}
}
