package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class A2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane borderPand = new BorderPane();
		HBox hBox = new HBox(10);
		Label fileLabel = new Label("File Name:");
		TextField textField = new TextField("mamoun.txt");
		Button loadBT = new Button("Load");
		hBox.getChildren().addAll(fileLabel, textField, loadBT);
		hBox.setAlignment(Pos.CENTER);
		borderPand.setTop(hBox);
		Label label = new Label(" I like javaFX!!!");
		borderPand.setCenter(label);
		Button button = new Button("Save");
		borderPand.setBottom(button);
		BorderPane.setAlignment(button, Pos.BOTTOM_CENTER);
		Scene scene = new Scene(borderPand, 300, 300);
		stage.setTitle("File Editor Interface");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
