package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToeGame extends Application {

    private static final int SIZE = 3;
    private String currentPlayer = "X";
    private Button[][] buttons = new Button[SIZE][SIZE];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");

        GridPane grid = createGrid();

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button button = new Button();
                button.setMinSize(90, 90);
                button.setStyle("-fx-font-size: 2em;");
                button.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

                button.setOnAction(e -> handleButtonClick(button));

                buttons[i][j] = button;
                grid.add(button, i, j);
            }
        }

        return grid;
    }

    private void handleButtonClick(Button button) {
        if (button.getText().isEmpty()) {
            button.setText(currentPlayer);
            button.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
            button.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

            if (checkForWinner()) {
                announceWinner();
            } else if (isBoardFull()) {
                announceDraw();
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
    }

    private boolean checkForWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (buttons[i][0].getText().equals(currentPlayer)
                    && buttons[i][1].getText().equals(currentPlayer)
                    && buttons[i][2].getText().equals(currentPlayer)) {
                return true;
            }

            if (buttons[0][i].getText().equals(currentPlayer)
                    && buttons[1][i].getText().equals(currentPlayer)
                    && buttons[2][i].getText().equals(currentPlayer)) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(currentPlayer)
                && buttons[1][1].getText().equals(currentPlayer)
                && buttons[2][2].getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons[0][2].getText().equals(currentPlayer)
                && buttons[1][1].getText().equals(currentPlayer)
                && buttons[2][0].getText().equals(currentPlayer)) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void announceWinner() {
        System.out.println("Player " + currentPlayer + " wins!");
        resetGame();
    }

    private void announceDraw() {
        System.out.println("It's a draw!");
        resetGame();
    }

    private void resetGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setStyle(null);
                buttons[i][j].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
            }
        }
        currentPlayer = "X";
    }
}