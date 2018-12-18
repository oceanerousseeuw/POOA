package drawing.ui;

import javafx.scene.layout.Pane;
import java.lang.Iterable;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import drawing.Observable;
import drawing.Observer;
import drawing.handlers.MouseMoveHandler;
import drawing.handlers.SelectionHandler;
import drawing.shapes.IShape;

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
    
    public DrawingPane(DrawingPane drawingPane) {
    	this.mouseMoveHandler = drawingPane.mouseMoveHandler;
    	this.selectionHandler = drawingPane.selectionHandler;
    	this.shapes = drawingPane.shapes;
    	this.observers = drawingPane.observers;
    	this.nbShapes = drawingPane.nbShapes;
    	this.nbSelectedShapes = drawingPane.nbSelectedShapes;
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
    
    
    /**
     * a placer dans mon deleteCommand
     */
    public void delete() {
    	List<IShape> selectedShapes = getSelection();
    	for (IShape shape : selectedShapes) {
        	shape.removeShapeFromPane(this);
        	shapes.remove(shape);
        }
    	selectionHandler.deleteSelectedShapes();
    	notifyObservers();
    }
    
    public void removeShape(IShape shape) {
		shapes.remove(shape);
		shape.removeShapeFromPane(this);
		notifyObservers();
    }

    /**
     * fin 
     */
    
    
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

	public SelectionHandler getSelectionHandler() {
		return selectionHandler;
	}

	public void setSelectionHandler(SelectionHandler selectionHandler) {
		this.selectionHandler = selectionHandler;
	}

	public ArrayList<IShape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<IShape> shapes) {
		this.shapes = shapes;
	}
	
	
	
}
