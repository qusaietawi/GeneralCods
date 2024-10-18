package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class Activity3  extends Application{
	private static final int SIZE = 8;
    private static final int CELL_SIZE = 50;
	public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Rectangle rectangle = new Rectangle(CELL_SIZE, CELL_SIZE, (row + col) % 2 == 0 ? Color.WHITE : Color.BLACK);
                gridPane.add(rectangle, col, row);
            }
        }

        Scene scene = new Scene(gridPane, SIZE * CELL_SIZE, SIZE * CELL_SIZE);

        primaryStage.setTitle("Checkerboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
	

}
