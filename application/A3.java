package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class A3 extends Application {
	String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	String[] mounth = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	GridPane gridPane = new GridPane();
	GregorianCalendar gregorianCalendar = new GregorianCalendar();
	BorderPane borderPane = new BorderPane();

	@Override
	public void start(Stage stage) throws Exception {
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		printCalender(0);
		Button prior = new Button("Prior"), next = new Button("Next");
		HBox hBox = new HBox(20, prior, next);
		hBox.setAlignment(Pos.CENTER);
		

		
		borderPane.setCenter(gridPane);
		borderPane.setBottom(hBox);
		borderPane.setAlignment(gridPane, Pos.CENTER);
		Scene scene = new Scene(borderPane);
		stage.setTitle("Calender");
		stage.setScene(scene);
		stage.show();
	}

	private void printCalender(int x) {
		gridPane.getChildren().clear();
		gregorianCalendar.set(Calendar.DATE, 1);
		gregorianCalendar.set(Calendar.MONTH, gregorianCalendar.get(Calendar.MONTH) + x);
		Label monthLabel = new Label(mounth[gregorianCalendar.get(Calendar.MONTH)] + "," + gregorianCalendar.get(Calendar.YEAR));
		
		borderPane.setTop(monthLabel);
		borderPane.setAlignment(monthLabel, Pos.CENTER);
		int j = 1;
		for (int i = 0; i < 49; i++) {
			if (i < days.length) {
				Label l = new Label(days[i]);
				gridPane.add(l, i, 0);
			} else if (j <= gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) && (i - 6) >= gregorianCalendar.get(Calendar.DAY_OF_WEEK)) {
				Label l = new Label(j + "");
				j++;
				gridPane.add(l, i % 7, i / 7);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}