package app.view;

import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MainPageController {
	
	private static Main main;
	@FXML
    private Label logLabel;
	public String logMessage = "BSDGUJHGHJ";
	@FXML
    private MenuItem miNew;

    @FXML
    private MenuItem miOpen;

    @FXML
    private MenuItem miQuit;

    @FXML
    private Menu miEdit;

    @FXML
    private MenuItem miUpdate;

    @FXML
    private MenuItem miDelete;
    
    @FXML
    public void handleQuit(ActionEvent event) {
    	System.exit(0);

    }
    
    @SuppressWarnings("static-access")
	@FXML
    public void handleHome() throws IOException {
    	main.showWelcomePage();
    }
    
    //Controllers for Search to Edit Page
    @FXML
    private Button btnCancelSE;

    @SuppressWarnings("static-access")
	@FXML
    private void handleCancelSE(ActionEvent event) throws IOException {
    	main.closeSearchForEdit();
    }
    @SuppressWarnings("static-access")
	@FXML
    private void handleBtnEdit(ActionEvent event) throws IOException {
    	main.showEdit();
    }
    @SuppressWarnings("static-access")
	@FXML
    private void handleNew() throws IOException {
    	main.createNewPage();
    }
    @SuppressWarnings("static-access")
	@FXML
    private void handleOpen() throws IOException {
    	main.searchResults();
    }
    @SuppressWarnings("static-access")
	@FXML
    private void handleDev() throws IOException {
    	main.showDevelopersPage();
    }
    //Controllers for Search for Delete Page
    @FXML
    private Button btnDeleteCancel;

    @FXML
    private Button btnDeleteDone;

    @FXML
    private Button btnDeleeDelete;
    
    @FXML
    private Text deleteMessage;

    @FXML
    void handleBtnDelete(ActionEvent event) {
    	btnDeleteDone.setVisible(true);
    	deleteMessage.setVisible(true);
    }
    @SuppressWarnings("static-access")
	@FXML
    private void handleBtnDeleteCancel(ActionEvent event) throws IOException {
    	main.closeSearchForDelete();
    }
    @SuppressWarnings("static-access")
	@FXML
    public void handleDeleteDone(ActionEvent event) throws IOException {
    	main.closeSearchForDelete();
    	//logMessage="Delete Done";
    	//showLog();
    	Label lab = new Label(logMessage);
    	//main.mainLayout.setCenter(lab);
    }
    
    //Log Handlers
    @FXML
	public ImageView imgLogOff;

    //------

    @FXML
    public ImageView imgLogOn;
    
    @SuppressWarnings("static-access")
	@FXML
    public void handleLogOffImage() throws IOException {
    	imgLogOff.setVisible(false);
    	imgLogOn.setVisible(true);
    	//main.Log();
    	//showLog();
    }
    @SuppressWarnings("static-access")
	@FXML
    public void handleLogOnImage() throws IOException {
    	imgLogOn.setVisible(false);
    	imgLogOff.setVisible(true);
    	//main.LogClose();
    	//showLog();
    }
    
	public boolean showLog() { //String logMsg, boolean logStat
		System.out.println(logMessage);
    	if(true) {
    		//logLabel.setVisible(true);
    		logLabel.setText("Logs: "+logMessage);
    	}
    	else {
    		logLabel.setText("Logs: Switched Off");
    		//logLabel.setVisible(true);
    	}
    	return true;
    }

}
