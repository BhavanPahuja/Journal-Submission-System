package project;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class authorUploadController implements Initializable
{
	private ObservableList<String> subjectList = FXCollections.observableArrayList("Physics", "Chemistry", "Biology", "Philiosophy", "Pscyhology", "English");
	private List<String> lstFile;
	
	 @FXML
	    private AnchorPane anchorPaneID;

	    @FXML
	    private Rectangle grayBackground;

	    @FXML
	    private Rectangle whiteTop;

	    @FXML
	    private Text authorTitle;

	    @FXML
	    private Button uploadJournal;

	    @FXML
	    private Label chooseSubject;
	    
	    @FXML
	    private Label feedbackLabel;

	    @FXML
	    private ChoiceBox<String> listOfSubjects;
	    
	    @FXML
	    private ChoiceBox<String> listOfReviewers1;
	    
	    @FXML
	    private ChoiceBox<String> listOfReviewers2;
	    
	    @FXML
	    private ChoiceBox<String> listOfReviewers3;
	    

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
	    private void home(ActionEvent event) throws Exception
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
	    private void onUploadClick(ActionEvent event) {
	    	FileChooser fc = new FileChooser();
	    	fc.getExtensionFilters().add(new ExtensionFilter("PDF Files", lstFile));
	    	File f = fc.showOpenDialog(null);
	    	if(f != null) {
	    		feedbackLabel.setText(f.getAbsolutePath());
	    	}
	    }	    

	
		public void initialize(URL url, ResourceBundle rb) 
		{
			listOfSubjects.setItems(subjectList);
	    	
	    	lstFile = new ArrayList<>();
	    	lstFile.add("*.pdf");
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
