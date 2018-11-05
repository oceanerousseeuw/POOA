package drawing;

import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionHandler implements EventHandler<MouseEvent> {

	private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    private List<IShape> selectedShapes = new ArrayList<>();
    
    public SelectionHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMouseClicked(this);
    }
    
	@Override
	public void handle(MouseEvent event) {
		//si il clique sur une shape sans maj
		if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            
            
            Iterator it = drawingPane.iterator();
            while(it.hasNext()) {
            	IShape shape = (IShape) it.next();
                if (shape.isOn(event.getX(), event.getY())) {
                	//si appuie sur MAJ
                	if(!selectedShapes.contains(shape) && event.isShiftDown()){
                		this.addOneShape(shape);
                	}else {
                		this.removeOneShape(shape);
                	}
                	if(!event.isShiftDown()) {
	            		if(selectedShapes.contains(shape)){
	            			this.clearSelectedShapes();
	            			this.removeOneShape(shape);
	            			break;
	            		}else{
	            			this.clearSelectedShapes();
	            			selectedShapes.clear();
	            			this.addOneShape(shape);
	            			break;
	            		}
                	}
                }
            }
        }
	}
	
	//ajout d'une forme a la liste
	public void addOneShape(IShape shape)  {
		selectedShapes.add(shape);
		shape.setSelected(true);
	}
	
	//supprimer une forme de la liste
	public void removeOneShape(IShape shape) {
		shape.setSelected(false);
		selectedShapes.remove(shape);
	}
	
	//déselectionner toutes les chapes de la listes
	public void clearSelectedShapes() {
		for(IShape selectedShape : selectedShapes) {
			selectedShape.setSelected(false);
		}
	}
	
	public List<IShape> getSelectedShapes() {
		return selectedShapes;
	}

}
