package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Optional;

public class TaskManagerApp extends Application {

    private ObservableList<Task> tasks = FXCollections.observableArrayList();
    private ListView<Task> taskListView = new ListView<>();
    private TextField taskNameField = new TextField();
    private TextArea taskDescriptionArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Task Manager");

        BorderPane root = new BorderPane();
        root.setLeft(createTaskListView());
        root.setCenter(createTaskDetailsView());
        root.setBottom(createButtonBar());

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private VBox createTaskListView() {
        VBox vBox = new VBox(10);
        Label tasksLabel = new Label("Tasks:");
        vBox.getChildren().addAll(tasksLabel, taskListView);
        taskListView.setItems(tasks);

        taskListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                displayTaskDetails(newValue);
            }
        });

        return vBox;
    }

    private VBox createTaskDetailsView() {
        VBox vBox = new VBox(10);
        Label detailsLabel = new Label("Task Details:");

        vBox.getChildren().addAll(detailsLabel, new Label("Name:"), taskNameField, new Label("Description:"), taskDescriptionArea);
        return vBox;
    }

    private HBox createButtonBar() {
        HBox buttonBar = new HBox(10);
        Button addButton = new Button("Add Task");
        Button editButton = new Button("Edit Task");
        Button deleteButton = new Button("Delete Task");

        addButton.setOnAction(event -> handleAddTask());
        editButton.setOnAction(event -> handleEditTask());
        deleteButton.setOnAction(event -> handleDeleteTask());

        buttonBar.getChildren().addAll(addButton, editButton, deleteButton);
        return buttonBar;
    }

    private void handleAddTask() {
        String taskName = taskNameField.getText().trim();
        String taskDescription = taskDescriptionArea.getText().trim();

        if (!taskName.isEmpty()) {
            Task newTask = new Task(taskName, taskDescription);
            tasks.add(newTask);
            clearTaskFields();
        }
    }

    private void handleEditTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            String newName = taskNameField.getText().trim();
            String newDescription = taskDescriptionArea.getText().trim();
            selectedTask.setName(newName);
            selectedTask.setDescription(newDescription);
            taskListView.refresh();
        }
    }

    private void handleDeleteTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationDialog.setTitle("Delete Task");
            confirmationDialog.setHeaderText("Confirm Deletion");
            confirmationDialog.setContentText("Are you sure you want to delete this task?");

            Optional<ButtonType> result = confirmationDialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                tasks.remove(selectedTask);
                clearTaskFields();
            }
        }
    }

    private void displayTaskDetails(Task task) {
        taskNameField.setText(task.getName());
        taskDescriptionArea.setText(task.getDescription());
    }

    private void clearTaskFields() {
        taskNameField.clear();
        taskDescriptionArea.clear();
    }

    public static class Task {
        private String name;
        private String description;

        public Task(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
