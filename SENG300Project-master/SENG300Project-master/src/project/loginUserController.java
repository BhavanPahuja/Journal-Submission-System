package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.scene.paint.Color;


/*
Controller class for the Registration UI .fxml file.
Allows the user login with e-mail and password and verifies against the users.csv file.
For now it prints to the console: true for a successful credentials and false for unsuccessful credentials.
*/

public class loginUserController implements Initializable
{
	private static Scanner input;
	
    @FXML
    private Label userEmailLabel;
    
    @FXML
    private Label passLabel;
    
    @FXML
    private Label loginLabel;
    
    @FXML
    private TextField userEmail;
    
    @FXML
    private PasswordField passW;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Button cancelButton;
    
	boolean acceptableLogin = false;
    
	
	@FXML
    private void handleLogin (ActionEvent event)
    {
    	boolean found = false;
        String passwordInput = passW.getText();
        String emailInput = userEmail.getText();

        String tempUsername = "";
		String tempPassword = "";
		String filename = "users.csv";

		try
		{
			input = new Scanner(new File (filename)); 	//reads the users.csv file 
			input.useDelimiter("[,\n]");				//each field is separated by a comma, and each record separated by a new line
		
			while(input.hasNext() && !found)
			{
				tempUsername = input.next();
				tempPassword = input.next();
				
				if (tempUsername.trim().contentEquals(emailInput.trim()) && tempPassword.trim().contentEquals(passwordInput.trim()))
				{
					found = true;
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login Attempt");
				}
			}
			input.close();
			
			if (found == true) {
				JOptionPane.showMessageDialog(null, "Login Confirmed");
				// Platform.exit();
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Something ain't right, and it is not because of your username and password!");
		}
        
    }

	@FXML
    private void cancel (ActionEvent event) throws Exception
    {
    	Parent root = FXMLLoader.load(getClass().getResource("startPageGUI.fxml"));
    	Main.stage.setScene(new Scene(root));
    }
	
    public void initialize(URL url, ResourceBundle rb)
    {

        loginButton.setOnAction(this::handleLogin);
        cancelButton.setOnAction(arg0 ->
        {
			try
			{
				cancel(arg0);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
    }
}
