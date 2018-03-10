import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * This is a simple application that change the color and size of a circle
 */
public class circleJavafx extends Application {
    // main
    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception {
        // setting up
        primaryStage.setTitle("Circle !!!");
        FlowPane root = new FlowPane(Orientation.VERTICAL);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.BOTTOM_CENTER);

        // make circle
        HBox cirHb = new HBox(16);
        Circle circle = new Circle(120, Color.INDIANRED);
        cirHb.getChildren().add(circle);
        cirHb.setAlignment(Pos.TOP_CENTER);
        cirHb.setPrefSize(root.getWidth(), root.getHeight());
        root.getChildren().add(cirHb);


        // make buttons
        Button red = new Button("Red");
        Button green = new Button("green");
        Button blue = new Button("blue");
        red.setPadding(new Insets(10,20,10,20));
        green.setPadding(new Insets(10,20,10,20));
        blue.setPadding(new Insets(10,20,10,20));
        red.setStyle("-fx-background-color: indianred");
        red.setTextFill(Color.WHITE);
        green.setStyle("-fx-background-color: forestgreen");
        green.setTextFill(Color.WHITE);
        blue.setStyle("-fx-background-color: deepskyblue");
        blue.setTextFill(Color.WHITE);
        // create a horizontal layout for coloring
        HBox colorHb = new HBox(16, red, green, blue);
        colorHb.setAlignment(Pos.BOTTOM_CENTER);
        colorHb.setPadding(new Insets(150, 50, 50, 50));
        // zooming part
        HBox zoomHb = new HBox(16);
        Button zoomIn = new Button("Zoom In");
        Button zoomOut = new Button("Zoom Out");
        zoomIn.setPadding(new Insets(10, 30, 10, 30));
        zoomOut.setPadding(new Insets(10, 30, 10,30));
        zoomIn.setStyle("-fx-background-color:khaki");
        zoomOut.setStyle("-fx-background-color:khaki");
        zoomHb.getChildren().addAll(zoomIn, zoomOut);
        zoomHb.setAlignment(Pos.BOTTOM_CENTER);
        // add them to panel
        root.getChildren().addAll(colorHb, zoomHb);


        primaryStage.setScene(new Scene(root, 300, 600));
        primaryStage.show();

        // set listeners
        red.setOnAction(event -> circle.setFill(Color.INDIANRED));
        green.setOnAction(event -> circle.setFill(Color.FORESTGREEN));
        blue.setOnAction(event -> circle.setFill(Color.DEEPSKYBLUE));
        zoomIn.setOnAction(event -> circle.setRadius(circle.getRadius()+12));
        zoomOut.setOnAction(event -> circle.setRadius(circle.getRadius()-12));

    }

}
