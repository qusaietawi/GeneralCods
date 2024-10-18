package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GoodJavaFXApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Good JavaFX App");

        // Creating form components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> handleSubmit(nameField.getText(), ageField.getText()));

        // Creating layout grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Adding components to the grid
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);
        grid.add(submitButton, 1, 2);

        primaryStage.setScene(new Scene(grid, 300, 200));
        primaryStage.show();
    }

    private void handleSubmit(String name, String age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
