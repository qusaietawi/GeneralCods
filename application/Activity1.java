package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Activity1  extends Application {
	@Override
    public void start(Stage primaryStage) {
        // Create an ImageView and load an image
        ImageView imageView = new ImageView();
        Image image = new Image("file:\\Users\\qusai\\OneDrive\\Desktop\\mh.jpg"); // Replace with the path to your image

        // Set the image to the ImageView
        imageView.setImage(image);

        // Create a StackPane and add the ImageView to it
        StackPane root = new StackPane();
        root.getChildren().add(imageView);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(root, 400, 300); // Adjust the size as needed
        primaryStage.setScene(scene);

        // Set the title of the Stage
        primaryStage.setTitle("Image Display App");

        // Show the Stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


