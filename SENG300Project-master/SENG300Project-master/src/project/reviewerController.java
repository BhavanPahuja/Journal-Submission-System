package project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.*;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class reviewerController {
	
	
	private ObservableList<String> decisionList = FXCollections.observableArrayList("Accepted", "Rejected", "Major Revision", "Minor Revision");
	private List<String> lstFile;
	
    @FXML
    private AnchorPane anchorPaneID;

    @FXML
    private Rectangle grayBackground;

    @FXML
    private Rectangle redTop;

    @FXML
    private Text reviewertTitle;

    @FXML
    private Button downloadJournal;

    @FXML
    private Button uploadFeedback;

    @FXML
    private ChoiceBox<String> decisionChoiceBox;

    @FXML
    private Button submitDecision;

    @FXML
    private Button signOut;

    @FXML
    private ImageView logoID;

    @FXML
    private Text resultOfEVal;
    
    @FXML
    private VBox vertBox;
    
    @FXML
    private Label feedbackLabel;
    

    @FXML
    private void onDownloadClick(ActionEvent event) {
    	
    	try
    	{
	    	String path = ".\\AuthorSubmission\\ReviwerFeedback_(2020-03-21_17-58-13).pdf"; // Test Path
	
	    	File file = new File(path);

	    	if(file.exists())
	    	{
	    		Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+path);
	    		pro.waitFor(); 
	
	    	}
	    	else
	    	{
	    		//Something pops up that says couldn’t be found
	    		System.out.println("In the else!");
	    	}
    	} 
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    private void onSignOutClick(ActionEvent event) {

    }

    @FXML
    private void onSubmitClick(ActionEvent event) throws IOException{
    	String feedbackInput = feedbackLabel.getText();
    	File source = new File(feedbackInput);
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("(yyyy-MM-dd_HH-mm-ss)");  
    	LocalDateTime now = LocalDateTime.now();  
   
    	File dest = new File(".\\ReviewerFeedback\\ReviewerFeedback_"+dtf.format(now)+".pdf");
    	Files.copy(source.toPath(), dest.toPath());
    	
    	String destFeedbackPath = dest.toString();
    	
    	String selectedDecision = decisionChoiceBox.getSelectionModel().getSelectedItem();
    	
    	String filepath = "ReviewerDecision.csv";
    	
    	try {
			FileWriter fwRev = new FileWriter(filepath, true);
			BufferedWriter bwRev = new BufferedWriter(fwRev);
			PrintWriter pwRev = new PrintWriter(bwRev);
				
			pwRev.println(destFeedbackPath+","+selectedDecision); //!
			pwRev.flush();
			pwRev.close();
			
			
			
			JOptionPane.showMessageDialog(null, "File Sent to:\n "+destFeedbackPath);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "File Not Sent");

		}
    	
    	
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
    
    @FXML
    private void initialize() {
    	decisionChoiceBox.setItems(decisionList);
    	
    	lstFile = new ArrayList<>();
    	lstFile.add("*.pdf");
    }
    
    

}
