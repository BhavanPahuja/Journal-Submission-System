package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class startPageController implements Initializable
{
	
    @FXML
    private Button signupButton;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private void addUserGUI (ActionEvent event) throws Exception
    {
//    	Parent.getChildren().setAll(FXMLLoader.load("addUserGUI.fxml"));
//    	Parent.getChildren(FXMLLoader.load(getClass().getResource("startPageGUI.fxml")));
    	Parent root = FXMLLoader.load(getClass().getResource("addUserGUI.fxml"));
    	Main.stage.setScene(new Scene(root));
    }

    @FXML
    private void loginUserGUI (ActionEvent event) throws Exception
    {
//    	Parent.getChildren().setAll(FXMLLoader.load("loginUserGUI.fxml"));
    	Parent root = FXMLLoader.load(getClass().getResource("LoginUserGUI.fxml"));
    	Main.stage.setScene(new Scene(root));
    }

    public void initialize(URL url, ResourceBundle rb)
    {
//        signupButton.setOnAction(this::addUserGUI);
    	signupButton.setOnAction(arg0 ->
    	{
    		try
			{
				addUserGUI(arg0);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
       loginButton.setOnAction(arg0 ->
       {
    	   	try
    	   	{
    	   		loginUserGUI(arg0);
    	   	}
    	   	catch
    	   	(Exception e)
    	   	{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
       });
    }
}
