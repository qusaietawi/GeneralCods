package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
public class QuizM extends Application {
    @Override
    public void start(Stage stage) {
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        Label first = new Label("First Name:");
        Label last = new Label("Last Name:");
        HBox Box1 = new HBox(10, first, firstName);
        HBox Box2 = new HBox(10,last, lastName);
        VBox Box = new VBox(20, Box1,Box2);
        Pane pane = new Pane();
        Circle face = new Circle(100, 50, 40);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.BLACK);
        pane.getChildren().add(face);
        Circle leftEye = new Circle(85, 35, 5);
        leftEye.setFill(Color.BLACK);
        Circle rightEye = new Circle(115, 35, 5);
        rightEye.setFill(Color.BLACK);
        pane.getChildren().addAll(leftEye, rightEye);
        Arc mouth = new Arc(100, 50, 30, 20, 0, -180);
        mouth.setType(ArcType.OPEN);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLACK);
        pane.getChildren().add(mouth);
        Label text = new Label(" Sample label for Fount & Color");
        text.setStyle("-fx-font-size: 25");
        text.setTextFill(Color.RED);
        HBox Box3 = new HBox(5, Box, pane);
        VBox Box4 = new VBox(10, Box3, text);
        Scene scene = new Scene(Box4, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}