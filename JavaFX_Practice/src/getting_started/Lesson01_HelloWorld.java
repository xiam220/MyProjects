package getting_started;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Lesson01_HelloWorld extends Application{
	
	public static void main(String[] args) {
		// Run JAR files that were created w/o the JavaFX Launcher
		launch(args);
	}
	
	// Start is the primary entry point for all JavaFX applications
	// UI defined by stage and scene.
	// Stage is the top-level JavaFX container
	public void start(Stage primaryStage) {
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		
		// StackPane is a resizable layout node
		// root  node's size tracks the scene's size; changes when stage
		// is resized by the user
		StackPane root = new StackPane();
		// Contains 1 child node, a button control w/ text, and an event
		// handler to print a message when the button is pressed
		root.getChildren().add(btn);
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
