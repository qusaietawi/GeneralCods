package application;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Activity5 extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		double[] scores = { 35, 55, 10};
		String[] grades = { "Scientific", "Literary", "Other"};
		Text text1 = new Text(100, 15, grades[0]+ " " + scores[0] + "%");
		Arc arc1 = new Arc(100, 100, 80, 80, 0, 360 * (scores[0] / 100));
		arc1.setFill(Color.RED);
		arc1.setType(ArcType.ROUND);
		Text text2 = new Text(10, 190, grades[1]+ " " + scores[1] + "%");
		Arc arc2 = new Arc(100, 100, 80, 80, arc1.getStartAngle() + arc1.getLength(),360 * (scores[1] / 100));
		arc2.setFill(Color.LIGHTBLUE);
		arc2.setType(ArcType.ROUND);
		Text text3 = new Text(180, 120, grades[2] + " " + scores[2] + "%");
		Arc arc3 = new Arc(100, 100, 80, 80, arc2.getStartAngle() + arc2.getLength(),360 * (scores[2] / 100));
		arc3.setFill(Color.GREEN);
		arc3.setType(ArcType.ROUND);
		pane.getChildren().addAll(arc1,text1, arc2,text2, arc3,text3);
        stage.setTitle("Tawjihi statistics");
		Scene scene = new Scene(pane,250,200);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	 }
}