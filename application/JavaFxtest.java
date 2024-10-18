package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxtest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple JavaFX App");

        Button btn = new Button();
        btn.setText("Click me!");

        // Handling button click event
        btn.setOnAction(e -> System.out.println("Button clicked!"));
        																														
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 200));

        primaryStage.show();
    }

}
