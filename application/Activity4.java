package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Activity4 extends Application {

    @Override
    public void start(Stage stage) {
		Text text1 = new Text("projects -- 20%");
		Rectangle rectangle1 = new Rectangle(100,40);
		rectangle1.setFill(Color.RED);
        VBox percentages1 = new VBox(10,text1,rectangle1);
        percentages1.setAlignment(Pos.BOTTOM_CENTER);
        Text text2 = new Text("quizzes -- 10%");
		Rectangle rectangle2 = new Rectangle(100,20);
		rectangle2.setFill(Color.BLUE);
        VBox percentages2 = new VBox(10, text2,rectangle2);
        percentages2.setAlignment(Pos.BOTTOM_CENTER);
        Text text3 = new Text("midterm -- 20%");
		Rectangle rectangle3 = new Rectangle(100,60);
		rectangle3.setFill(Color.GREEN);
        VBox percentages3 = new VBox(10, text3,rectangle3);
        percentages3.setAlignment(Pos.BOTTOM_CENTER);
        Text text4 = new Text("final -- 40%");
		Rectangle rectangle4 = new Rectangle(100,80);
		rectangle4.setFill(Color.ORANGE);
        VBox percentages4 = new VBox(10, text4,rectangle4);
        percentages4.setAlignment(Pos.BOTTOM_CENTER);
    	HBox percentages = new HBox(10,percentages1,percentages2,percentages3,percentages4);
        percentages.setAlignment(Pos.BOTTOM_CENTER);
    	stage.setTitle("Display a bar chart");
        Scene scene = new Scene(percentages,500,150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}