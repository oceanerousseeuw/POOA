package drawing.ui;

import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.ShapeButtonHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonFactory {

	public ButtonFactory() {
		
	}
	
	public static final String clear = "clear";
	public static final String rectangle = "rectangle";
	public static final String circle = "circle";
	public static final String triangle = "triangle";
	public static final String delete = "delete";
	
	public Button createButton(String buttonName) {

		System.out.println("ici2");
		String tooltip ="";
		String imageName ="";
		
		switch(buttonName) {
		case clear:
			tooltip = "Clear all shapes";
			imageName = "clear";
			break;
		case rectangle:
			tooltip = "Create rectangle";
			imageName = "rectangle";
			break;
		case circle:
			tooltip = "Create circle";
			imageName = "circle";
			break;
		case triangle:
			tooltip = "Create triangle";
			imageName = "triangle";
			break;
		case delete:
			tooltip = "Delete selected shapes";
			imageName = "delete";
			break;
		}
		
		Image icone = new Image(getClass().getResourceAsStream("../images/" + imageName + ".png"), 25, 25, true, true);
		Button button = new Button("", new ImageView(icone));
		button.setTooltip(new Tooltip(tooltip));
		
		return button;
		
	}
	
}
