package app.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SearchController implements Initializable{
	
	private Main main;
	private Manage mg;
	@FXML private Button btnSearch;
    @FXML private Button btnCancel;
    @FXML private TextField SFname;
    @FXML private TextField SFemail;
    @FXML private TextField SF10th;
    @FXML private TextField SF12th;
    @FXML private TextField SFbcklgs;
    @FXML private TextField SFagg;
    @FXML private TextField SFspec;
    @FXML private ImageView imgBack1;
    @FXML private ComboBox<String> SFbranch;
    
	public static String TEMP;
	ObservableList<String> branches = FXCollections.observableArrayList("All Branches","ISE","CSE","ECE","CIV","MECH");
	    
    @SuppressWarnings("static-access")
	@FXML
    private void handleCancel() throws IOException {
    	main.onCancel();
    }
      
    @SuppressWarnings("static-access")
	@FXML
    private void handleBack2() throws IOException {
    	main.searchPageHome();
    }
    //-=---------
    @FXML private CheckBox cbBacklogs;
    @FXML void handleCbBacklogs() {
    	if(cbBacklogs.isSelected()) {
    		SFbcklgs.setVisible(true);
    	}
    	else {
    		SFbcklgs.setVisible(false);
    	}
    }
    @SuppressWarnings("static-access")
	@FXML void handleSearchBtn() throws IOException {
    	//String searchTexts = SFname.getText()+"|"+SFemail.getText();
    	String name="";
    	String email="";
    	boolean isBcklg=false;
    	int maxBcklg=0;
    	Double m10=(double) 0;
    	Double m12=(double) 0;
    	Double agg=(double) 0;
    	String spec ="";
    	String branch="";
    	if(cbBacklogs.isSelected()) {
    		isBcklg=true;
    		maxBcklg=Integer.parseInt(SFbcklgs.getText());
    	}
    	if(SFname.getLength()>0)
    		name=SFname.getText();
    	if(SFemail.getLength()>0)
    		email=SFemail.getText();
    	if(SF10th.getLength()>0)
    		m10=Double.parseDouble(SF10th.getText());
    	if(SF12th.getLength()>0)
    		m12=Double.parseDouble(SF12th.getText());
    	if(SFagg.getLength()>0)
    		agg=Double.parseDouble(SFagg.getText());
    	if(SFspec.getLength()>0)
    		spec=SFspec.getText();
    	branch = (String) SFbranch.getValue();
    	if(branch.equals("All Branches"))
    		branch = "";
    	mg.getString(name, email, m10, m12, agg, isBcklg, branch, maxBcklg,spec);
    	main.searchResults();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SFbranch.setItems(branches);
		SFbranch.getSelectionModel().selectFirst();
	}
}
