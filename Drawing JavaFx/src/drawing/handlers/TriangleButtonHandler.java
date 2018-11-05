package drawing.handlers;

import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import drawing.ui.DrawingPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class TriangleButtonHandler extends ShapeButtonHandler{

	public TriangleButtonHandler(DrawingPane drawingPane) {
        super(drawingPane);
    }

    @Override
    protected IShape createShape() {
        double x = Math.min(originX, destinationX);
        double y = Math.min(originY, destinationY);
        double width = Math.abs(destinationX - originX);
        double height = Math.abs(destinationY - originY);
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[] {
        		originX, originY,
        		destinationX, destinationY,
        		originX, destinationY
        });
        
        triangle.getStyleClass().add("triangle");
        
        ShapeAdapter adapterTriangle = new ShapeAdapter(triangle);
        
        return adapterTriangle;
    }
}
