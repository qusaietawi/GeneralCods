package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class GuessTheNumberGame extends Application {

    private int targetNumber;
    private int numberOfTries;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Guess the Number Game");

        // Generate a random number between 1 and 100
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        //System.out.println(targetNumber);
        Label instructionLabel = new Label("Guess the number between 1 and 100:");
        TextField guessTextField = new TextField();
        Button guessButton = new Button("Guess");
        Label resultLabel = new Label("");
        resultLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-stoke: #555555;");
        instructionLabel.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #555555;");
        guessButton.setOnAction(event -> handleGuess(guessTextField.getText(), resultLabel));

        VBox layout = new VBox(10);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-spacing: 10; -fx-alignment: center;"); // Inline styling for spacing and alignment
        layout.getChildren().addAll(instructionLabel, guessTextField, guessButton, resultLabel);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void handleGuess(String input, Label resultLabel) {
        try {
            int guess = Integer.parseInt(input);
            numberOfTries++;

            if (guess >= 1 && guess <= 100) {
                if (guess == targetNumber) {
                    resultLabel.setText("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                    disableGuessing(resultLabel);
                } else if (guess < targetNumber) {
                    resultLabel.setText("Try a higher number.");
                } else {
                    resultLabel.setText("Try a lower number.");
                }
            } else {
                resultLabel.setText("Please enter a number between 1 and 100.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private void disableGuessing(Label resultLabel) {
        resultLabel.setText(resultLabel.getText() + " Game over.");
        resultLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 10, 0, 0, 0);");
    }
}