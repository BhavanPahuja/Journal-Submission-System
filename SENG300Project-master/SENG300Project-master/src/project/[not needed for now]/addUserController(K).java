package project;

import java.io.File;
import java.util.Scanner;

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
import javafx.scene.paint.Color;


/*
Controller class for the Registration UI .fxml file.
Allows the user to create an account consisting of their First and Last Names, Password, Email Address, Affiliation and Account type.
The user information is stored in the userinfo.csv and users.csv files.
*/

public class addUserController implements Initializable {
	
    @FXML
    private Label nameLabel;
    
    @FXML
    private Label passLabel;
    
    @FXML
    private Label emailLabel;
    
    @FXML
    private Label affilLabel;
    
    @FXML
    private Label accTypeLabel;
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private PasswordField passW;
    
    @FXML
    private PasswordField confirmPassW;
    
    @FXML
    private TextField emailAdd;
    
    @FXML
    private TextField confirmEmailAdd;
    
    @FXML
    private TextField affil;
    
    @FXML
    private ChoiceBox<String> accType;

    @FXML
    private Button confirmForm;
    
    @FXML
    private Button submitForm;
    
    @FXML
    private Button cancelButton;
    
	boolean acceptableReg = false;
    
    @FXML
    private void errChecking (ActionEvent event) {
    	
    	int Check_1 = 0;
    	int Check_2 = 0;
    	int Check_3 = 0;
    	int Check_4 = 0;
    	int Check_5 = 0;
    	
        String checkSelection = accType.getSelectionModel().getSelectedItem();
        String emailFormat = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    	
        //	Error Checking for First and Last Names
        if (firstName.getText().length() <= 0 || lastName.getText().length() <= 0) {
        	nameLabel.setText("That name is invalid!");
        	nameLabel.setAlignment(Pos.CENTER);
        	nameLabel.setTextFill(Color.RED);
        	
        	Check_2 = 0;
        	
        } else {
        	nameLabel.setText("Satisfactory");
        	nameLabel.setTextFill(Color.GREEN);
        	
        	Check_1 = 1;
        }
        
        // Error checking for Password
        
        if (!passW.getText().equals(confirmPassW.getText())) {
        	passLabel.setText("Your Passwords don't match!");
        	passLabel.setAlignment(Pos.CENTER);
        	passLabel.setTextFill(Color.RED);
        	
        	passW.clear();
        	confirmPassW.clear();
        	
        	Check_2 = 0;
        	
        } else if (passW.getText().length() <= 0 || confirmPassW.getText().length() <= 0){
        	passLabel.setText("Enter and confirm your password!");
        	passLabel.setAlignment(Pos.CENTER);
        	passLabel.setTextFill(Color.RED);
        	
        	Check_2 = 0;
        	
        } else {
        	passLabel.setText("Satisfactory");
        	passLabel.setTextFill(Color.GREEN);
        	
        	Check_2 = 1;
        }
        
        // Error checking for Email Address
        
        if (!emailAdd.getText().equals(confirmEmailAdd.getText())) {
        	emailLabel.setText("Your Email doesn't match!");
        	emailLabel.setAlignment(Pos.CENTER);
        	emailLabel.setTextFill(Color.RED);
        	
        	emailAdd.clear();
        	confirmEmailAdd.clear();
        	
        	Check_3 = 0;
        	
        } else if (emailAdd.getText().length() <= 0 || confirmEmailAdd.getText().length() <= 0){
        	emailLabel.setText("Enter and confirm your Email!");
        	emailLabel.setAlignment(Pos.CENTER);
        	emailLabel.setTextFill(Color.RED);
        	
        	Check_3 = 0;
        	
        } else if (!emailAdd.getText().matches(emailFormat)){
        	emailLabel.setText("That isn't a valid Email!");
        	emailLabel.setAlignment(Pos.CENTER);
        	emailLabel.setTextFill(Color.RED);
        	
        	Check_3 = 0;
        	
        } else {
        	emailLabel.setText("Satisfactory");
        	emailLabel.setTextFill(Color.GREEN);
        	
        	Check_3 = 1;
        }
        
        // Error checking for Affiliation
        if (affil.getText().length() <= 0){
        	affilLabel.setText("Enter your Affiliation!");
        	affilLabel.setAlignment(Pos.CENTER_LEFT);
        	affilLabel.setTextFill(Color.RED);
        	
        	Check_4 = 0;
        	
        } else {
        	affilLabel.setText("Satisfactory");
        	affilLabel.setAlignment(Pos.CENTER_LEFT);
        	affilLabel.setTextFill(Color.GREEN);
        	
        	Check_4 = 1;
        }
        
        // Error checking for Account Type selection
        if (checkSelection == null){
        	accTypeLabel.setText("Enter your Account Type!");
        	accTypeLabel.setAlignment(Pos.CENTER_LEFT);
        	accTypeLabel.setTextFill(Color.RED);
        	
        	Check_5 = 0;
        	
        } else {
        	accTypeLabel.setText("Satisfactory");
        	accTypeLabel.setAlignment(Pos.CENTER_LEFT);
        	accTypeLabel.setTextFill(Color.GREEN);
        	
        	Check_5 = 1;
        }
        
        // Determines whether the form is acceptable for submission
        if (Check_1 + Check_2 + Check_3 + Check_4 + Check_5 == 5) {
        	acceptableReg = true;
        }
        else {
        	acceptableReg = false;
        }
    }

	
    @FXML
    private void handleSubmit (ActionEvent event)
    {
    	if (acceptableReg == true) {
	    	// Gets all the necessary text and stores them as strings
	        String firstNameInput = firstName.getText();
	        String lastNameInput = lastName.getText();
	        String passwordInput = passW.getText();
	        String emailInput = emailAdd.getText();
	        String affilInput = affil.getText();
	        String selectedAccType = accType.getSelectionModel().getSelectedItem();
	        
	        String filepath1 = "userinfo.csv";
	        String filepath2 = "users.csv";
	        
        
            try {
            	
            	// Storing User's information
            	
            	FileWriter fw1 = new FileWriter(filepath1, true);
            	BufferedWriter bw1 = new BufferedWriter(fw1);
            	PrintWriter pw1 = new PrintWriter(bw1);
            	
            	pw1.println(firstNameInput+","+lastNameInput+","+emailInput+","+affilInput+","+selectedAccType);
            	pw1.flush();
            	pw1.close();

            	// Storing User's password with the associated Name(s)
            	
            	FileWriter fw2 = new FileWriter(filepath2, true);
            	BufferedWriter bw2 = new BufferedWriter(fw2);
            	PrintWriter pw2 = new PrintWriter(bw2);

            	pw2.println(emailInput+","+passwordInput);
            	pw2.flush();
            	pw2.close();
            	
            }
            catch (Exception E) {
            	System.out.println("EXCEPTION e!");
            }
            
            JOptionPane.showMessageDialog(null, "Form Submitted");
            
            Platform.exit();
            
        } else {
        	JOptionPane.showMessageDialog(null, "Confirm the form before you submit!");
        }
    }

	@FXML
    private void cancel (ActionEvent event) throws Exception
    {
    	Parent root = FXMLLoader.load(getClass().getResource("startPageGUI.fxml"));
    	Main.stage.setScene(new Scene(root));
    }

    public void initialize(URL url, ResourceBundle rb){
        ObservableList<String> accTypeChoices = FXCollections.observableArrayList("Author", "Reviewer");
        accType.setItems(accTypeChoices);

        confirmForm.setOnAction(this::errChecking);
        submitForm.setOnAction(this::handleSubmit);
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
