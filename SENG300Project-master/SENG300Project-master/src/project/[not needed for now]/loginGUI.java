package project;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class loginGUI extends Application
{

	@Override
    // the GUI class
	public void start(Stage primaryStage) throws Exception
	{
		GridPane loginPane = new GridPane();
		
		loginPane.setAlignment(Pos.CENTER);
		loginPane.setHgap(5);
		loginPane.setVgap(5);
		loginPane.setGridLinesVisible(false);
		Scene scene = new Scene(loginPane, 640, 480);
		
		Label fname = new Label("First name");
		loginPane.add(fname, 0, 0);                    // add the label object to the pane and give it location 
		TextField fnameT = new TextField();
		loginPane.add(fnameT, 1, 0);
		
		Label password = new Label("password");
		loginPane.add(password, 0, 3);  
		PasswordField passwordT = new PasswordField();
		loginPane.add(passwordT, 1, 3);

		Button btnButton  = new Button("Login");
		HBox hbBtnBox = new HBox(10);
		hbBtnBox.setAlignment(Pos.CENTER);
		hbBtnBox.getChildren().add(btnButton);
		loginPane.add(hbBtnBox, 1, 5);
		
		btnButton.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent event)
			{
				System.out.println ("Checking credentials...");
				Label email = new Label("Logging in...");
				loginPane.add(email, 0, 7);  
			}
		});
		//Button newButton = new Button ();                    // create a button object
		//newButton.setText ("Hello guys");                   // give it text
		//layOut.getChildren().add(newButton);                // display the button on a pane
		
		primaryStage.setScene(scene);                    // a stage (window) to display the scene
		primaryStage.show ();                           // start the stage
	}

	public static void main (String[] args)
	{
		launch(args);
	}
}