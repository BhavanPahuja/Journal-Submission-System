package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class authorMainController implements Initializable
{
	
//		@FXML
//	    private AnchorPane anchorPaneID;

	    @FXML
	    private Rectangle grayBackground;

	    @FXML
	    private Rectangle whiteTop;

	    @FXML
	    private Text authorTitle;

	    @FXML
	    private Button uploadJournal;

	    @FXML
	    private Button downloadFeedback;
	  
	    @FXML
	    private Button logOut;
	   
	    @FXML
	    private Button notifications;
	    
	    @FXML
	    private Button home;	    

	    @FXML
	    private ImageView logoID;

	    @FXML
	    private ImageView notificationsIcon;
	    
	    @FXML
	    private ImageView logOutIcon;

	    @FXML
	    private ImageView homeIcon;
	    
	    @FXML
		private void authorMainGUI(ActionEvent event) throws Exception
	    {		   
	    	Parent root = FXMLLoader.load(getClass().getResource("authorMainGUI.fxml"));
	    	Main.stage.setScene(new Scene (root));
		}
	    
	    
	    @FXML
	    private void logOut(ActionEvent event) throws Exception
	    {
	    	Parent root = FXMLLoader.load(getClass().getResource("startPageGUI.fxml"));
			Main.stage.setScene(new Scene (root));
	    }	   
	    
	   @FXML
	   private void authorDownload(ActionEvent event) throws Exception
	   {		   
		   Parent root = FXMLLoader.load(getClass().getResource("authorDownloadGUI.fxml"));
		   Main.stage.setScene(new Scene (root));
	   }
	   
	   @FXML
	   private void authorUpload(ActionEvent event) throws Exception
	   {		   
		   Parent root = FXMLLoader.load(getClass().getResource("authorUploadGUI.fxml"));
		   Main.stage.setScene(new Scene (root));
	   }
	    
	    
	    public void initialize(URL url, ResourceBundle rb) 
	    {
	    	home.setOnAction(arg0 ->
	    	{
	    		try
	    		{
	    			authorMainGUI(arg0);
	    		}
	    		catch (Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    	});
	    	
	    	uploadJournal.setOnAction(arg0 ->
	    	{
	    		try
	    		{
	    			authorUpload(arg0);
	    		}
	    		catch(Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    	});
	    	
	    	downloadFeedback.setOnAction(arg0 ->
	    	{
	    		try
	    		{
	    			authorDownload(arg0);
	    		}
	    		catch(Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    	});
	    	
	    	
	    	logOut.setOnAction(arg0 ->
			{
				try
				{
					logOut(arg0);
				}
				catch(Exception e)
	    		{
	    			e.printStackTrace();
	    		}
			});
	    	
	    }	   

}