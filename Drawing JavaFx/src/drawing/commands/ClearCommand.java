package drawing.commands;

import drawing.ui.DrawingPane;

public class ClearCommand implements ICommand{
	
	private DrawingPane drawingPane;
	private DrawingPane drawingPaneCopy;
	
	
	public ClearCommand(DrawingPane drawingPane){
		this.drawingPane = drawingPane; 
    }
	@Override
	public void execute() {
		drawingPaneCopy = new DrawingPane(this.drawingPane);
		drawingPane.clear();
	}

	@Override
	public void undo() {
		drawingPane = drawingPaneCopy;
	}


}
