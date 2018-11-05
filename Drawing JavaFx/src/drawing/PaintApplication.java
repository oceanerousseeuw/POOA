package drawing;

import drawing.ui.DrawingPane;
import drawing.ui.StatutBar;
import drawing.ui.ToolBar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class PaintApplication extends Application {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Scene scene;
    private BorderPane root;
    private DrawingPane drawingPane;

    private ToolBar toolBar;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        scene = new Scene(root, WIDTH, HEIGHT);

        root.getStylesheets().add(
                PaintApplication.class.getResource("./css/Paint.css").toExternalForm());

        drawingPane = new DrawingPane();
        drawingPane.getStyleClass().add("drawingPane");
        root.setCenter(drawingPane);

        HBox hBox = new HBox();
        toolBar = new ToolBar(drawingPane);
        
        hBox.getChildren().addAll(toolBar.getClearButton(), toolBar.getRectangleButton(), toolBar.getCircleButton(), 
        		toolBar.getTriangleButton(), toolBar.getDeleteButton());
        hBox.setPadding(new Insets(5));
        hBox.setSpacing(5.0);
        hBox.getStyleClass().add("toolbar");
        root.setTop(hBox);
        
        StatutBar statutLabel = new StatutBar();
        statutLabel.getStyleClass().add("statutLabel");
        root.setBottom(statutLabel);
        Label myLabel = statutLabel.getLabel();
        statutLabel.getChildren().add(myLabel);

        drawingPane.addObserver(statutLabel);

        primaryStage.setTitle("Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public DrawingPane getDrawingPane() {
        return drawingPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
