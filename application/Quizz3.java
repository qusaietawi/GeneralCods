package application;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.Random;

public class Quizz3 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();

        Circle outerCircle = new Circle();
        outerCircle.setStroke(Color.RED);
        outerCircle.setFill(Color.WHEAT);

        Circle innerCircle = new Circle();
        innerCircle.setStroke(Color.RED);
        innerCircle.setFill(Color.WHEAT);

        DoubleBinding outerRadiusBinding = primaryStage.widthProperty().divide(3);
        DoubleBinding innerRadiusBinding = primaryStage.widthProperty().divide(5);

        outerCircle.radiusProperty().bind(outerRadiusBinding);
        innerCircle.radiusProperty().bind(innerRadiusBinding);

        outerCircle.centerXProperty().bind(primaryStage.widthProperty().divide(2));
        outerCircle.centerYProperty().bind(primaryStage.widthProperty().divide(2));
        innerCircle.centerXProperty().bind(primaryStage.widthProperty().divide(2));
        innerCircle.centerYProperty().bind(primaryStage.widthProperty().divide(2));

        root.getChildren().addAll(outerCircle, innerCircle);

        int numberOfTriangles = new Random().nextInt(5) + 1;

        for (int i = 0; i < numberOfTriangles; i++) {
            Polygon triangle = createRandomTriangle();
            triangle.setFill(Color.RED);
            root.getChildren().add(triangle);
        }

        Label label = new Label("Free Palestine");
        label.setFont(new javafx.scene.text.Font(30));
        label.setTextFill(Color.RED);

        Label labe2 = new Label("Qusai Etawi");
        labe2.setFont(new javafx.scene.text.Font(25));
        labe2.setTextFill(Color.BLUE);


        VBox vbox = new VBox(label, root, labe2);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Resized Circles");
        primaryStage.show();
    }

    private Polygon createRandomTriangle() {
        double size = 20; 
        double[] points = {
                Math.random() * 100, Math.random() * 100,
                Math.random() * 100, Math.random() * 100,
                Math.random() * 100, Math.random() * 100
        };
        return new Polygon(points);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
