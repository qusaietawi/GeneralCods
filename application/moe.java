package application;

// Import the required JavaFX classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class moe extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane root = new Pane();

		Ellipse ellipse = new Ellipse(150, 50, 140, 40);
		ellipse.setFill(Color.YELLOW);
		root.getChildren().add(ellipse);

		Label welcomeLabel = new Label("Welcome From Java 2");

		welcomeLabel.setLayoutX(80);
		welcomeLabel.setLayoutY(40);
		welcomeLabel.setTextFill(Color.BLUE);
		root.getChildren().add(welcomeLabel);
		Rectangle r = new Rectangle();
		r.setX(115);
		r.setY(150);
		r.setWidth(70);
		r.setHeight(200);
		r.setArcWidth(10);
		r.setArcHeight(10);
		r.setFill(Color.GREEN);
		root.getChildren().add(r);
		Rectangle r1 = new Rectangle();
		r1.setX(50);
		r1.setY(215);
		r1.setWidth(200);
		r1.setHeight(70);
		r1.setArcWidth(10);
		r1.setArcHeight(10);
		r1.setFill(Color.YELLOW);
		root.getChildren().add(r1);
		Rectangle r2 = new Rectangle();
		r2.setX(50);
		r2.setY(215);
		r2.setWidth(200);
		r2.setHeight(70);
		r2.setArcWidth(10);
		r2.setArcHeight(10);
		r2.setFill(Color.BLUE);
		r2.setRotate(-45);
		root.getChildren().add(r2);
		Rectangle r3 = new Rectangle();
		r3.setX(50);
		r3.setY(215);
		r3.setWidth(200);
		r3.setHeight(70);
		r3.setArcWidth(10);
		r3.setArcHeight(10);
		r3.setFill(Color.RED);
		r3.setRotate(45);
		root.getChildren().add(r3);

		TextField nameField = new TextField();
		nameField.setLayoutX(220);
		nameField.setLayoutY(400);
		root.getChildren().add(nameField);
		TextField nameField1 = new TextField();
		nameField1.setLayoutX(0);
		nameField1.setLayoutY(400);
		root.getChildren().add(nameField1);

		Button okButton = new Button("Ok button");
		okButton.setLayoutX(150);
		okButton.setLayoutY(400);
		root.getChildren().add(okButton);
		Label nameLabel = new Label("Qusai Etawi");
		nameLabel.setLayoutX(350);
		nameLabel.setLayoutY(300);
		nameLabel.setTextFill(Color.RED);
		root.getChildren().add(nameLabel);

		Scene scene = new Scene(root, 500, 500);

		primaryStage.setTitle("Java 2 Interface");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}