package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoteCode extends Application {

    private ListView<String> notesListView;
    private TextField noteTextField;

    

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Note App");

        // Create UI controls
        notesListView = new ListView<>();
        noteTextField = new TextField();
        Button addButton = new Button("Add Note");
        Button removeButton = new Button("Remove Selected");

        // Add note button event handling
        addButton.setOnAction(e -> addNote());

        // Remove selected note button event handling
        removeButton.setOnAction(e -> removeSelectedNote());

        // Layout setup
        HBox inputBox = new HBox(10, noteTextField, addButton);
        VBox mainLayout = new VBox(10, inputBox, notesListView, removeButton);

        // Create scene
        Scene scene = new Scene(mainLayout, 300, 400);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void addNote() {
        String newNote = noteTextField.getText().trim();
        if (!newNote.isEmpty()) {
            notesListView.getItems().add(newNote);
            noteTextField.clear();
        }
    }

    private void removeSelectedNote() {
        int selectedIndex = notesListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            notesListView.getItems().remove(selectedIndex);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}