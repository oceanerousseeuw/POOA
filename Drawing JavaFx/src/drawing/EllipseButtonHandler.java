package drawing;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class EllipseButtonHandler extends ShapeButtonHandler {

    public EllipseButtonHandler(DrawingPane drawingPane) {
        super(drawingPane);
    }

    @Override
    protected IShape createShape() {
        double x = Math.min(originX, destinationX);
        double y = Math.min(originY, destinationY);
        double width = Math.abs(destinationX - originX);
        double height = Math.abs(destinationY - originY);
        Ellipse ellipse = new Ellipse(x + width / 2, y + height / 2, width / 2, height / 2);
        ellipse.getStyleClass().add("ellipse");
        
        ShapeAdapter adapterEllipse = new ShapeAdapter(ellipse);
        return adapterEllipse;
    }
}
