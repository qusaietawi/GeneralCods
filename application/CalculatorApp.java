package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField display;
    private String currentInput = "";
    private String selectedOperator = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Create UI controls
        display = new TextField();
        display.setEditable(false);
        
        display.setStyle("-fx-font-size: 18;");

        // Create number buttons
        Button[] numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createNumberButton(Integer.toString(i));
        }

        // Create operation buttons
        Button addButton = createOperationButton("+");
        Button subtractButton = createOperationButton("-");
        Button multiplyButton = createOperationButton("*");
        Button divideButton = createOperationButton("/");

        // Equal button
        Button equalButton = new Button("=");
        equalButton.setOnAction(e -> calculateResult());

        // Clear button
        Button clearButton = new Button("C");
        clearButton.setOnAction(e -> clear());

        // Layout setup
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        // Add controls to the grid
        grid.add(display, 0, 0, 4, 1);
        grid.add(numberButtons[7], 0, 1);
        grid.add(numberButtons[8], 1, 1);
        grid.add(numberButtons[9], 2, 1);
        grid.add(divideButton, 3, 1);
        grid.add(numberButtons[4], 0, 2);
        grid.add(numberButtons[5], 1, 2);
        grid.add(numberButtons[6], 2, 2);
        grid.add(multiplyButton, 3, 2);
        grid.add(numberButtons[1], 0, 3);
        grid.add(numberButtons[2], 1, 3);
        grid.add(numberButtons[3], 2, 3);
        grid.add(subtractButton, 3, 3);
        grid.add(numberButtons[0], 0, 4);
        grid.add(clearButton, 1, 4);
        grid.add(equalButton, 2, 4);
        grid.add(addButton, 3, 4);

        // Create scene
        Scene scene = new Scene(grid, 300, 400);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private Button createNumberButton(String text) {
        Button button = new Button(text);
        button.setOnAction(e -> appendToInput(text));
        return button;
    }

    private Button createOperationButton(String operator) {
        Button button = new Button(operator);
        button.setOnAction(e -> handleOperation(operator));
        return button;
    }

    private void appendToInput(String value) {
        currentInput += value;
        display.setText(currentInput);
    }

    private void handleOperation(String operator) {
        if (!currentInput.isEmpty()) {
            selectedOperator = operator;
            currentInput += " " + operator + " ";
            display.setText(currentInput);
        }
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && currentInput.contains(" ")) {
            String[] parts = currentInput.split(" ");
            double operand1 = Double.parseDouble(parts[0]);
            double operand2 = Double.parseDouble(parts[2]);
            double result = 0;

            switch (selectedOperator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(Double.toString(result));
            currentInput = Double.toString(result);
        }
    }

    private void clear() {
        currentInput = "";
        selectedOperator = "";
        display.clear();
    }
}
