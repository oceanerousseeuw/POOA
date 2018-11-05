import drawing.PaintApplication;
import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import drawing.ui.DrawingPane;
import drawing.ui.StatutBar;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class PaintTest extends ApplicationTest {

    PaintApplication app;

    @Override
    public void start(Stage stage) {
        try {
            app = new PaintApplication();
            app.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_draw_circle_programmatically() {
        interact(() -> {
                    app.getDrawingPane().addShape(new ShapeAdapter(new Ellipse(20, 20, 30, 30)));
                });
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_circle() {
        // given:
        clickOn("Circle");
        moveBy(60,60);

        // when:
        drag().dropBy(30,30);
        //press(MouseButton.PRIMARY); moveBy(30,30); release(MouseButton.PRIMARY);

        // then:
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_rectangle() {
        // given:
        clickOn("Rectangle");
        moveBy(0,60);

        // when:
        drag().dropBy(70,40);

        // then:
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }
    
    @Test
    public void should_draw_triangle() {
    	clickOn("Triangle");
    	moveBy(30,60).drag().dropBy(70, 40);
    	Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_clear() {
        // given:
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160).drag().dropBy(70,40);

        // when:
        clickOn("Clear");

        // then:
        assertFalse(app.getDrawingPane().iterator().hasNext());
    }
    
    @Test
    public void statut_bar_clear() {
    	//given:
    	clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160).drag().dropBy(70,40);
        
    	//when:
        clickOn("Clear");
        
    	//then:
        StatutBar myStatutBar = (StatutBar) app.getDrawingPane().getObservers().get(0);
        assertFalse(myStatutBar.getLabel().toString().equals("0 shape(s)"));	
    }
    
    
    @Test
    public void statut_bar_add_shapes() {
    	//given:
    	clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160);
        
    	//when:
        drag().dropBy(70,40);
        
    	//then:
        StatutBar myStatutBar = (StatutBar) app.getDrawingPane().getObservers().get(0);
        assertFalse(myStatutBar.getLabel().toString().equals("2 shape(s)"));	
    }
    
    @Test
    public void statut_bar_add_multiple_shapes() {
    	//given:
    	clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160).drag().dropBy(70,40);

    	//when:
        List<Node> children = app.getDrawingPane().getChildren();
        for(Node child : children) {
        	press(KeyCode.SHIFT).clickOn(child);
        }
        
    	//then:
        StatutBar myStatutBar = (StatutBar) app.getDrawingPane().getObservers().get(0);
        assertFalse(myStatutBar.getLabel().toString().equals("2 shape(s), 2 selected"));	
    }
    

}