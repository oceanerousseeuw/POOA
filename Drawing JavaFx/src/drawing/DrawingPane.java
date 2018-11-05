package drawing;

import javafx.scene.layout.Pane;
import java.lang.Iterable;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<IShape>, Observable, Observer{

    private MouseMoveHandler mouseMoveHandler;
    
    private SelectionHandler selectionHandler;

    private ArrayList<IShape> shapes;
    
    private ArrayList<Observer> observers;
    
    private int nbShapes;
    
    private int nbSelectedShapes;


    public DrawingPane() {
        clipChildren();
        shapes = new ArrayList<>();
        mouseMoveHandler = new MouseMoveHandler(this);
        selectionHandler = new SelectionHandler(this);
        observers = new ArrayList<>();
        
        selectionHandler.addObserver(this);
    }


    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        shape.addShapeToPane(this);
        notifyObservers();
    }

    public void clear() {
        for (IShape shape : shapes) {
        	shape.removeShapeFromPane(this);
        }
        shapes.clear();
        notifyObservers();
    }

	@Override
	public Iterator iterator() {
		return this.shapes.iterator();
	}
	
	/*
	 * Partie observable
	 */
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		nbShapes = shapes.size();
		for (Observer observer: observers) {
			observer.update(this);
		}
	}
	
	public int getNbShapes() {
		return nbShapes;
	}


	/*
	 * Partie observer
	 */
	public ArrayList<Observer> getObservers() {
		return observers;
	}
	
	public List<IShape> getSelection() {
		return selectionHandler.getSelectedShapes();
	}


	@Override
	public void update(Observable o) {
		nbSelectedShapes = this.getSelection().size();
		notifyObservers();
	}
	
	public int getNbSelected() {
		return nbSelectedShapes;
	}
	/*
	 * 
	 */
	
	
	
}
