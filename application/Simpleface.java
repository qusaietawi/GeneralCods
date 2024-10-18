package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class Simpleface  extends Application {
	@Override
	public void start(Stage stage) throws Exception {
	Pane pane = new Pane();
	Circle circle = new Circle(100 , 100 , 100);
	circle.setFill(Color.WHITE);
	circle.setStroke(Color.BLACK);
	Rectangle rectangle = new Rectangle(90, 90, 20, 40);
	rectangle.setFill(Color.WHITE);
	rectangle.setStroke(Color.BLACK);
	Arc arc = new Arc(100, 130, 50, 20, 0, -180);
	arc.setType(ArcType.OPEN);
	arc.setFill(Color.WHITE);
	arc.setStroke(Color.BLACK);
	pane.getChildren().addAll(circle , rectangle , arc);
	for (int i = 0; i < 2; i++) {
	Circle c = new Circle(60+i*80, 60, 10);
	Ellipse e = new Ellipse(60+i*80, 60, 30, 20);
	e.setFill(Color.WHITE);
	e.setStroke(Color.BLACK);
	pane.getChildren().addAll(e , c);
	}
	Scene scene= new Scene(pane);
	stage.setTitle("Ryan Gosling");
	stage.setScene(scene);
	stage.show();
	}
	public static void main(String[] args) {
	Application.launch(args);
	}

}
