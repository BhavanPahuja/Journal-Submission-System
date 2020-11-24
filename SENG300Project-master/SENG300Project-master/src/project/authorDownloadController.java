package project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class authorDownloadController implements Initializable
{
	
	
	 @FXML
	    private AnchorPane anchorPaneID;

	    @FXML
	    private Rectangle grayBackground;

	    @FXML
	    private Rectangle whiteTop;

	    @FXML
	    private Text authorTitle;
	    
	    @FXML 
	    private Button downloadFeedback;

	    @FXML
	    private Label evaluationResult;
	    
	    @FXML
	    private Label decisionMade;
	    
	    @FXML
	    private Button logOut;
	    
	    @FXML
	    private Button home;
	   
	    
	    @FXML
	    private Button notifications;

	    @FXML
	    private ImageView logoID;

	    @FXML
	    private ImageView notificationsIcon;
	    
	    @FXML
	    private ImageView logOutIcon;
	    
	    @FXML
	    private ImageView homeIcon;
	    
	    
	    @FXML
	    private void logOut(ActionEvent event) throws Exception
	    {
	    	Parent root = FXMLLoader.load(getClass().getResource("startPageGUI.fxml"));
			Main.stage.setScene(new Scene (root));
	    }	
	    
	    @FXML
	    private void home(ActionEvent event) throws Exception
	    {
	    	Parent root = FXMLLoader.load(getClass().getResource("authorMainGUI.fxml"));
			Main.stage.setScene(new Scene (root));
	    }
	    
	    @FXML
	    private void onDownloadClick(ActionEvent event) {
	    	
	    	try
	    	{
		    	String path = ".\\ReviewerFeedback\\ReviwerFeedback_(2020-03-21_17-51-17).pdf"; // Test Path
		
		    	File file = new File(path);

		    	if(file.exists())
		    	{
		    		Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+path);
		    		pro.waitFor(); 
		
		    	}
		    	else
		    	{
		    		//Something pops up that says couldn’t be found
		    		System.out.println("No file available");
		    	}
	    	} 
	    	catch (Exception e)
	    	{
	    		e.printStackTrace();
	    	}

	    }
	    

		public void initialize(URL url, ResourceBundle rb) 
		{
			//decisionMade.setText(reviewerController.selectedDecision);
			
			home.setOnAction(arg0 ->
			{
				try
				{
					home(arg0);
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
