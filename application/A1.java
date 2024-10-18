package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class A1  extends Application{
	public void start(Stage stage) throws Exception {
	GridPane gridpane = new GridPane();
	for (int i = 0; i < 3; i++) {
		for(int j = 0 ; j < 3 ; j++) {
	Label lable = new Label((int)(Math.random()*2) + "");
	lable.setFont(new Font(30));
	lable.setStyle("-fx-border-color : red; -fx-border-width : 5");
	lable.setPrefHeight(100);
	lable.setPrefWidth(100);
	lable.setAlignment(Pos.CENTER);
	lable.prefWidthProperty().bind(gridpane.widthProperty().divide(3));
	lable.prefHeightProperty().bind(gridpane.heightProperty().divide(3));
	gridpane.add(lable, i, j);
	
	}
	}
	Scene scene = new Scene(gridpane);
	
	stage.setScene(scene);
	stage.show();
	}
	public static void main(String[] args) {
	launch(args);
	}

}
