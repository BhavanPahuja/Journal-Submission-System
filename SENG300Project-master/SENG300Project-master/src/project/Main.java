package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application
{
	
	public static Stage stage;
	
	@Override
    public void start (Stage primaryStage) throws Exception
	{
	// Gets the selected .fxml UI
        Parent root = FXMLLoader.load(getClass().getResource("authorMainGUI.fxml"));
        stage = primaryStage;
        stage.setTitle("Registration/Login Form");
        stage.setScene(new Scene(root, 863, 571));
        stage.show();
    }
	
	public static void main(String[] args)
	{
		launch(args);
	}
}