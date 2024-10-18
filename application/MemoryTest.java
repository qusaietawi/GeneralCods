package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MemoryTest extends Application {
	private ArrayList<Martyr> ListOfMartyrs = new ArrayList<>();
	private TextField firstText = new TextField();
	private TextField secondText = new TextField();
	private Label result = new Label();
	

	private boolean inList(String name) {
		for (Martyr martyr : ListOfMartyrs) {
			if (martyr.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	private void firstWindowShow() {
		Stage FirstStage = new Stage();
		Button FirstWindow = new Button("“Create Martyr List Window”");
		FirstWindow.setStyle("-fx-background-color: LIGHTBLUE; -fx-text-fill: BLACK;");
		FirstWindow.setOnAction(e -> {
			FirstStage.close();
			TextField TextOfAddMartyr = new TextField();
			Label LabelOfAddMartyr = new Label("Add Martyr(Name Date Of Martyrdom) : ");
			Button addToTheFiel = new Button("Add To File");
			addToTheFiel.setStyle("-fx-background-color: LIGHTPINK; -fx-text-fill: BLACK;");
			HBox hbox = new HBox(15, LabelOfAddMartyr, TextOfAddMartyr, addToTheFiel);
			hbox.setAlignment(Pos.CENTER);
			addToTheFiel.setOnAction(o -> {
				try (DataOutputStream data = new DataOutputStream(new FileOutputStream("MartyrsList.dat", true))) {
					data.writeUTF(TextOfAddMartyr.getText());
					TextOfAddMartyr.clear();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			});
			Button firstBack = new Button("Back to main menu");
			firstBack.setStyle("-fx-background-color: LIGHTPINK; -fx-text-fill: BLACK;");
			firstBack.setOnAction(w -> {
				FirstStage.close();
				
				firstWindowShow();

			});
			VBox vbox1 = new VBox(30, hbox, firstBack);
			vbox1.setAlignment(Pos.CENTER);
	        FirstStage.setTitle("Add a Martyr to the file");
			Scene scene1 = new Scene(vbox1, 600, 300);
			FirstStage.setScene(scene1);
			FirstStage.show();

		});
		Button SecondWindow = new Button("“Memory Test Window“");
		SecondWindow.setStyle("-fx-background-color: LIGHTBLUE; -fx-text-fill: BLACK;");
		firstText.setStyle("-fx-background-color: BLUE; -fx-text-fill: BLACK;");
		firstText.setPrefColumnCount(20);
		secondText.setStyle("-fx-background-color: BLUE; -fx-text-fill: BLACK;");
		secondText.setPrefColumnCount(10);
		SecondWindow.setOnAction(b -> {
			FirstStage.close();
			
			
			Stage secondstage = new Stage();
			Label labelOfTest = new Label("Test Your Memory");
			labelOfTest.setAlignment(Pos.CENTER);
			labelOfTest.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30");
			Label label0 = new Label("Hey My Friend, Test your memory to see if you remember who martyrted before.");
			label0.setAlignment(Pos.CENTER);
			Label label2 = new Label("Pick two Martyrs Name from the following list, Enter them in the boxes in the correct order (date of death) then press the Submit Boutton");
			label2.setAlignment(Pos.CENTER);
			//print();			
			//FlowPane pane = new FlowPane();
			//for (Martyrs martyr : ListOfMartyrs) {
			//    Label labell = new Label(martyr.getName());
			 //   pane.getChildren().add(labell);
			//}
			//pane.setAlignment(Pos.CENTER);
			VBox top = new VBox(20, labelOfTest, label0, label2);
			top.setAlignment(Pos.CENTER);
			Button submit = new Button("Submit");
			submit.setStyle("-fx-background-color: LIGHTPINK; -fx-text-fill: BLACK;");
			submit.setOnAction(p -> {
				String firstMartyr = firstText.getText().trim();
				String secondMartyr = secondText.getText().trim();
				if (firstMartyr.isEmpty() || secondMartyr.isEmpty()) {
					result.setText("Enter names in both boxes. Then press Submit.");
				} else if (!inList(firstMartyr) && !inList(secondMartyr)) {
					result.setText("Neither entry is in the name list.");
				} else if (!inList(firstMartyr)) {
					result.setText("First entry not in name list – check spelling.");
				} else if (!inList(secondMartyr)) {
					result.setText("Second entry not in name list – check spelling.");
				} else if (firstMartyr.equalsIgnoreCase(secondMartyr)) {
					result.setText("You entered the same names, Try again.");
				} else if (inList(firstMartyr) && inList(secondMartyr)) {
					boolean first = false;
					boolean second = false;
					String firstDate = null;
					String secondDate = null;
					for (Martyr martyr : ListOfMartyrs) {
						if (martyr.getName().equalsIgnoreCase(firstMartyr)) {
							first = true;
							firstDate = martyr.getDateOfMartyrdom();
						}
						if (martyr.getName().equalsIgnoreCase(secondMartyr)) {
							second = true;
							secondDate = martyr.getDateOfMartyrdom();
						}
						if (second == true && first == true) {
							if (Integer.parseInt(firstDate) > Integer.parseInt(secondDate)) {
								result.setText("Wrong. Try again.");
							}
						}

					}

				} else {
					result.setText("You are correct!");
				}

				firstText.clear();
				secondText.clear();

			});

			Button clear = new Button("Clear");
			clear.setStyle("-fx-background-color: LIGHTPINK; -fx-text-fill: BLACK;");
			clear.setOnAction(e -> {
				firstText.clear();
				secondText.clear();

			});
			ComboBox<String> Color = new ComboBox<>();
			Color.setStyle("-fx-background-color: LIGHTPINK; -fx-text-fill: BLACK;");
			Color.getItems().addAll("Red", "Green", "Blue", "Yellow", "Purple", "GRAY");
			BorderPane bord = new BorderPane();

			Color.setOnAction(e -> {
				String color = Color.getValue();
				switch (color) {
				case "Red":
					bord.setStyle("-fx-background-color: Red;");
					break;
				case "Green":
					bord.setStyle("-fx-background-color: LIGHTGreen;");
					break;
				case "Blue":
					bord.setStyle("-fx-background-color: LIGHTBlue;");
					break;
				case "Yellow":
					bord.setStyle("-fx-background-color: Yellow;");
					break;
				case "Purple":
					bord.setStyle("-fx-background-color: Purple;");
					break;
				case "GRAY":
					bord.setStyle("-fx-background-color: LIGHTGRAY;");
					break;
				default:
					bord.setStyle("-fx-border-width: WHITE;");
					break;
				}
			});
			Button secondBack = new Button("Back to main menu");
			secondBack.setStyle("-fx-background-color: LIGHTPINK; -fx-text-fill: BLACK");
			secondBack.setOnAction(o -> {
				secondstage.close();
				firstWindowShow();

			});
			Label label3 = new Label(" martyred before :  ");
			HBox botom = new HBox(20, firstText, label3, secondText);
			botom.setAlignment(Pos.CENTER);
			HBox botom1 = new HBox(20, submit, clear, Color);
			botom1.setAlignment(Pos.CENTER);

			VBox botom2 = new VBox(20, botom, botom1, secondBack,result);
			botom2.setAlignment(Pos.CENTER);
			
				bord.setCenter(print());
			 
			bord.setTop(top);
			bord.setBottom(botom2);
	        secondstage.setTitle("Memory Test");
			Scene secen = new Scene(bord, 800, 400);
			secondstage.setScene(secen);
			secondstage.show();

		});

		VBox box = new VBox(20, FirstWindow, SecondWindow);
		box.setAlignment(Pos.CENTER);
        FirstStage.setTitle("The War On Gaza");
		Scene scene = new Scene(box, 300, 300);
		FirstStage.setScene(scene);
		FirstStage.show();

	}

	public FlowPane print()  {
		FlowPane p = new FlowPane();

		try {
		p.setHgap(25);
		p.setVgap(25);
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream("MartyrsList.dat"));
		try {
			while (dataInputStream.available() > 0) {
				Label label = new Label();
				String line = dataInputStream.readUTF();
				String data[] = line.split(" ");
				String name = data[0];
				String date = data[1];
				Martyr martyr = new Martyr(name, date);
				ListOfMartyrs.add(martyr);
				label.setText(name);
				label.setFont(new Font(20));
				p.getChildren().add(label);
				p.setAlignment(Pos.CENTER);
			}
		}catch (EOFException e) {
			System.out.println("mmmmmmmmmmmmm");
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dataInputStream.close();
		return p;

	}
	
	@Override
	public void start(Stage stage) throws Exception {
		firstWindowShow();

	}

	public static void main(String[] args) {
		launch(args);
	}

}