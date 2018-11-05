package drawing.ui;

import javafx.scene.layout.HBox;
import drawing.Observable;
import drawing.Observer;
import javafx.scene.control.Label;

public class StatutBar extends HBox implements Observer{
	
	Label label;
	
	public StatutBar() {
		this.label = new Label("0 shape(s), 0 selected");
	}

	public Label getLabel() {
		return this.label;
	}
	
	@Override
	public void update(Observable o) {
		DrawingPane drawingPane = (DrawingPane) o;
		int nbShapes = drawingPane.getNbShapes();
		int nbSelectedShapes = drawingPane.getNbSelected();
		this.label.setText(nbShapes + " shape(s), " + nbSelectedShapes + " selected");
	}
	

}
