package app.view;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ResourceBundle;

import app.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class CNPController implements Initializable{
	public Main main;
	@FXML private TextField CNname;
    @FXML private TextField CNusn;
    @FXML private TextField CNemail;
    @FXML private TextField CNphone;
    @FXML private ToggleGroup gender;
    @FXML private RadioButton CNmale;
    @FXML private RadioButton CNfemale;
    @FXML private RadioButton CNothers;
    @FXML private DatePicker CNdob;
    @FXML private TextField CN10th;
    @FXML private TextField CN12th;
    @FXML private CheckBox cbDiploma;
    @FXML private TextField tfDiplomaMarks;
    @FXML private TextField CNsem3;
    @FXML private TextField CNsem1;
    @FXML private TextField CNsem5;
    @FXML private TextField CNsem7;
    @FXML private TextField CNsem2;
    @FXML private TextField CNsem4;
    @FXML private TextField CNsem6;
    @FXML private TextField CNsem8;
    @FXML private TextField CNaggregate;
    @FXML private TextField CNtotalMarks;
    @FXML private TextField CNsp1;
    @FXML private TextField CNsp2;
    @FXML private TextField CNsp3;
    @FXML private TextField CNbcklg;
    @FXML private TextField CNprglang;
    @FXML private TextField CNproftools;
    @FXML private Button btnFileChoose;
    @FXML private Text fileNameDisplay;
    @FXML private Pane dispPDF;
    @FXML private ImageView loadingGIF;
    @FXML public ComboBox<String> CNbranch;
    @FXML private Label CNlogMsg;
    private File selectedFile = null;
    String TEMP,Line,T1,T2;
	int HashValue;
	String branch = "";
    String genderValue;
    String dobValue;
    String pl="";
    String pt="";
    String sp2="";
    String sp3="";
    String sp1="";
    String bcklg="0";
    String fileName="";
    ObservableList<String> branches = FXCollections.observableArrayList("ISE","CSE","ECE","CIV","MECH");
    @FXML private Button nextTab;
    @FXML private Button CNsaveBtn;
    @FXML private TabPane tabAll;
    @FXML private Tab tab1;
    @FXML private Tab tab2;
    @FXML private Tab tab3;
    @FXML private Tab tab4;
    
    @FXML void handleNextTab() {
    	tabAll.getSelectionModel().selectNext();
    	String tabName=tabAll.getSelectionModel().getSelectedItem().getText();
    	System.out.println(tabName);
    	if(tabName.equalsIgnoreCase("Resume")) {
    		nextTab.setVisible(false);
    		CNsaveBtn.setVisible(true);
    	}
    }
    @FXML
    void fileChoose(ActionEvent event) {
    	FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF files", "*.pdf"));
		selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile != null) {
			System.out.println("Selected Resume file PATH: "+selectedFile.getAbsolutePath());
			fileNameDisplay.setText(selectedFile.getName());
			fileNameDisplay.setVisible(true);
			dispPDF.setVisible(true);
		}
		else {
			System.out.println("File invalid");
		}
    }

    @FXML
    void viewPDF(ActionEvent event) throws IOException {
    	if(selectedFile != null) {
			Desktop.getDesktop().open(new File(selectedFile.getAbsolutePath()));
		}
		else {
			System.out.println("Can't open file");
		}
    }
    @FXML
	private void handleDip() {
    	if(cbDiploma.isSelected()) {
    		tfDiplomaMarks.setVisible(true);
    	}
    	else {
    		tfDiplomaMarks.setVisible(false);
    	}
    }
	@SuppressWarnings("static-access")
	@FXML
    private void handleCancel() throws IOException {
    	main.showWelcomePage();
    }
	@FXML
	public void onClickOfTotalMarks() {
		if((CNsem1.getLength()>0)&&(CNsem2.getLength()>0)&&(CNsem3.getLength()>0)&&(CNsem4.getLength()>0)) {
			int total = Integer.parseInt(CNsem1.getText());
			total += Integer.parseInt(CNsem2.getText());
			total += Integer.parseInt(CNsem3.getText());
			total += Integer.parseInt(CNsem4.getText());
			if(CNsem5.getLength()>0) {
				total += Integer.parseInt(CNsem5.getText());
				if(CNsem6.getLength()>0) {
					total += Integer.parseInt(CNsem6.getText());
					if(CNsem7.getLength()>0) {
						total += Integer.parseInt(CNsem7.getText());
					}
				}
			}
			CNtotalMarks.setText(String.valueOf(total));
		}
	}
	@FXML
	public void Save() throws IOException, InterruptedException {
		boolean add = false;
		//loadingGIF.setVisible(true);
		dobValue=CNdob.getValue().toString();
		if(CNmale.isSelected()) genderValue=CNmale.getText();
		if(CNfemale.isSelected()) genderValue=CNfemale.getText();
		if(CNothers.isSelected()) genderValue=CNothers.getText();
		if(CNprglang.getLength()>0) pl=CNprglang.getText();
		if(CNproftools.getLength()>0) pt=CNproftools.getText();
		if(CNsp1.getLength()>0) sp1=CNsp1.getText();
		if(CNsp2.getLength()>0) sp2=CNsp2.getText();
		if(CNsp3.getLength()>0) sp3=CNsp3.getText();
		if(CNbcklg.getLength()>0) bcklg=CNbcklg.getText();
		branch = (String) CNbranch.getValue();
		
		String from = selectedFile.getAbsolutePath();
		fileName = addPDFname()+selectedFile.getName();
		String to = main.dirname+"PDFresumes\\"+fileName;
		Path src = Paths.get(from);
        Path dest = Paths.get(to);
        Files.copy(src, dest);
		System.out.println(fileName);
		if((CNname.getLength()>0)&&(CNusn.getLength()>0)&&(CNemail.getLength()>0)&&(CNphone.getLength()>0)&&(CN10th.getLength()>0)&&(CN12th.getLength()>0)&&(CNaggregate.getLength()>0)&&(CNsp1.getLength()>0)) {
			TEMP=CNusn.getText();
			if(TEMP.matches("4[alAL]+[0-9][0-9][a-zA-Z]*[0-9]+")) {
				TEMP=CNemail.getText();
				if(TEMP.matches("[[0-9]*[a-z]*[0-9]*]+[@][a-z]+[.][a-z]+")) {
					add = true;
				}
			}
		}else {
			CNlogMsg.setText(" -Fill  all the details. - ");
			CNlogMsg.setTextFill(Color.web("#0076a3"));
			CNlogMsg.setVisible(true);
		}
		if(add) {
			Line = CNname.getText()+"#"+CNusn.getText()+"#"+CNemail.getText()+"#"+CNphone.getText()+"#"+genderValue+"#"+dobValue+"#"+CN10th.getText()+"#"+CN12th.getText()+"#"+CNtotalMarks.getText()+"#"+CNaggregate.getText()+"#"+branch+"#"+bcklg+"#"+pl+"#"+pt+"#"+sp1+"#"+sp2+"#"+sp3+"#"+fileName;
			if(AddtoFile(Line)==1) {
				try {
				CNlogMsg.setText(CNname.getText()+" -Successfully Added to File");
				CNlogMsg.setTextFill(Color.web("#00FF00"));
				CNlogMsg.setVisible(true);
				System.out.println(CNname.getText()+" -Successfully Added to File");
				System.out.println(Line);
				}
				catch(Exception e){
					CNlogMsg.setText(CNname.getText()+" -Unable to Add. - "+e);
					CNlogMsg.setTextFill(Color.web("#0076a3"));
					CNlogMsg.setVisible(true);
					System.out.println("Log: "+e);
				}
				finally {
					//flag = true;
					
				}
			}
		}
	}
	@SuppressWarnings("static-access")
	public int AddtoFile(String Line)
	{
		try {
		 Writer writer = new BufferedWriter(new OutputStreamWriter(
			        new FileOutputStream(main.RecFile, true), "UTF-8"));
		 HashValue=Line.hashCode();
		 writer.write(Line+"#"+HashValue+"\r\n");
		 writer.close();
		return 1;
		}
		catch(Exception E)
		{
			return 0;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CNbranch.setItems(branches);
		
	}
	static String addPDFname() 
    { 
		Random r = new Random();
		int n = r.nextInt((10 - 5) + 1) + 5;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }

}
