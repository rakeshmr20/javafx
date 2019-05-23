package app.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import app.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class UploadCSVController {
	
	private Main main;
	private CNPController cnp;
	private File selectedFile = null;
	@FXML private Text msgCSVfilename;
    @FXML private Button btnUploadCSV;
    @FXML private ListView<String> UCSVlv;
    
    @FXML
    private void fileChoose() throws IOException {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new ExtensionFilter("CSV files", "*.csv"));
		selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile != null) {
			System.out.println("Selected Resume file PATH: "+selectedFile.getAbsolutePath());
			msgCSVfilename.setText(selectedFile.getName());
			msgCSVfilename.setVisible(true);
			btnUploadCSV.setVisible(true);
			//Desktop.getDesktop().open(new File(selectedFile.getAbsolutePath()));
		}
		else {
			System.out.println("File invalid");
		}
	}
    
    @FXML
    private void uploadToFile() {
    	String csvFile = selectedFile.getAbsolutePath();
        String line = "";
        String cvsSplitBy = ",";
        String buffer="";
        int count=0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	UCSVlv.getItems().add("Adding records...");

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] words = line.split(cvsSplitBy);
                if(words[0].equals("Name")) continue;
                buffer +=words[0]+"#"+words[1]+"#"+words[2]+"#"+words[3]+"#"+words[4]+"#"+words[5]+"#"+words[6]+"#"+words[7]+"#"+words[8]+"#"+words[9]+"#"+words[10]+"#"+words[11]+"#"+words[12]+"#"+words[13]+"#"+words[14]+"#"+words[15]+"#"+words[16]+"#"+words[17];
                boolean success = AddtoFile(buffer);
                if(success) {
                	count++;
                	UCSVlv.getItems().add(String.valueOf(count)+": "+words[0]);
	                System.out.println(buffer);
	                buffer="";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("static-access")
	public boolean AddtoFile(String Line)
	{
		try {
		 Writer writer = new BufferedWriter(new OutputStreamWriter(
			        new FileOutputStream(main.RecFile, true), "UTF-8"));
		 int HashValue = Line.hashCode();
		 writer.write(Line+"#"+HashValue+"\r\n");
		 writer.close();
		 return true;
		}
		catch(Exception E)
		{
			return false;
		}
	}
    @SuppressWarnings("static-access")
	@FXML
    private void handleHome() throws IOException {
    	main.showWelcomePage();
    }

}
