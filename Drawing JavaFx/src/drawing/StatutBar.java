package drawing;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class StatutBar extends HBox implements Observer{
	
	Label label;
	
	public StatutBar() {
		this.label = new Label("0 shape(s)");
	}

	public Label getLabel() {
		return this.label;
	}
	
	@Override
	public void update(Observable o) {
		DrawingPane drawingPane = (DrawingPane) o;
		int value = drawingPane.getNbShapes();
		this.label.setText(value + " shape(s)");
	}
	

}
