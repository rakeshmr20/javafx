package app.view;

import java.io.IOException;

import app.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class WelcomePageController {
	
	private Main main;
	@FXML
    private ImageView imgQuit;

    @FXML
    private void handleImageQuit(MouseEvent event) {
    	//kill the App
    	System.exit(0);
    }
    
    @SuppressWarnings("static-access")
	@FXML
    private void handleCreateNewPage() throws IOException {
    	main.createNewPage();
    }
    
    @SuppressWarnings("static-access")
	@FXML
    private void handleSearchPage() throws IOException {
    	main.searchPageHome();
    }
    
    @SuppressWarnings("static-access")
	@FXML
    private void handleViewAll() throws IOException {
    	main.searchResults();
    }
    
    @SuppressWarnings("static-access")
	@FXML
    private void handleDelete() throws IOException {
    	main.searchResults();
    }
    
    @SuppressWarnings("static-access")
	@FXML
    private void handleUploadCSV() throws IOException {
    	main.showUploadCSVPage();
    }
    
    @SuppressWarnings("static-access")
	@FXML
    private void handleInfoPage() throws IOException {
    	main.showDevelopersPage();
    }

}
