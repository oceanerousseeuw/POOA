package drawing.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import drawing.Observable;
import drawing.Observer;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionHandler implements EventHandler<MouseEvent>, Observable {

	private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;
    
    private int nbShapesSelected;

    private ArrayList<Observer> observers;

    private List<IShape> selectedShapes = new ArrayList<>();
    
    public SelectionHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMouseClicked(this);
        observers = new ArrayList<>();
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
		notifyObservers();
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
	
	//déselectionner toutes les shapes de la listes
	public void clearSelectedShapes() {
		for(IShape selectedShape : selectedShapes) {
			selectedShape.setSelected(false);
		}
	}
	
	public void deleteSelectedShapes() {
		selectedShapes = new ArrayList();
		notifyObservers();
	}
	
	public List<IShape> getSelectedShapes() {
		return selectedShapes;
	}
	
	public int getNbSelectedShapes() {
		int nbSelectedShapes = selectedShapes.size();
		return nbSelectedShapes;
	}

	/*
	 * Partie observable
	 */
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);		
	}

	@Override
	public void notifyObservers() {
		nbShapesSelected = getNbSelectedShapes();
		for (Observer observer: observers) {
			observer.update(this);
		}
	}

}
