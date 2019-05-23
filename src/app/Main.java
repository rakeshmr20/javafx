package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage primaryStage;
	public static BorderPane mainLayout;
	private static Stage addDailogue = new Stage();
	
	//Create a Directory
	public static String dirname = "C:\\RakeshMR\\PRMfiles\\";
	public static String RecFile=dirname+"file.txt";
	public static String TempFile=dirname+"temp.txt";
	public static int count=1;
	//Search
	public static String TEMP;
	public static boolean logStatus = false;
    //public String logMessage = null;
    private static Stage addLogPage = new Stage();
    @FXML private ImageView imgLogClose;

    @FXML private static Text logMessage;

	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Placement Register Management - FS Project by Rakesh M R");
		Image img = new  Image("resources/icons8_groups_80px.png");
		this.primaryStage.getIcons().add(img);
		mainLayout = FXMLLoader.load(getClass().getResource("view/MainPage.fxml"));
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		//--------------------
		File d = new File(dirname);
		File dr = new File(dirname+"PDFresumes\\");
		boolean created = d.mkdirs();
		boolean createdPdfsFolder = dr.mkdirs();
		if(created && createdPdfsFolder) {
			System.out.println("Folder Created");
		}
		else {
			System.out.println("Folder already Exists");
		}
		//--------------------
		//aaaa
		addDailogue.setTitle("Search the Candidate to Edit");
		addDailogue.initModality(Modality.WINDOW_MODAL);
		addDailogue.initOwner(primaryStage);
		//aaa
		//-----------Add Log Page-----
		addLogPage.setTitle("Logs");
		addLogPage.initModality(null);
		addLogPage.initOwner(primaryStage);
		//----------------------------
		showWelcomePage();
	}

	public static void showWelcomePage() throws IOException {
		BorderPane welcome = FXMLLoader.load(Main.class.getResource("view/WelcomePage.fxml"));
		mainLayout.setCenter(welcome);
		primaryStage.setResizable(false);
	}
	
	public static void createNewPage() throws IOException {
		BorderPane createnew = FXMLLoader.load(Main.class.getResource("view/CreateNewPage.fxml"));
		mainLayout.setCenter(createnew);
		primaryStage.setResizable(true);
	}
	
	public static void searchPageHome() throws IOException {
		BorderPane searchHome = FXMLLoader.load(Main.class.getResource("view/SearchPage.fxml"));
		mainLayout.setCenter(searchHome);
		primaryStage.setResizable(false);
		
	}
	
	public static void searchResults() throws IOException {
		//-------
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/LoadingGIF.fxml"));
		BorderPane sfEdit = loader.load();
		Scene scene = new Scene(sfEdit);
		//scene.setFill(Color.TRANSPARENT);
		addDailogue.setScene(scene);
		addDailogue.show();
		//addDailogue.initStyle(Color.TRANSPARENT);
		//-----
		BorderPane searchRes = FXMLLoader.load(Main.class.getResource("view/SearchResults.fxml"));
		mainLayout.setCenter(searchRes);
		primaryStage.setResizable(true);
		
		addDailogue.close();
	}
	
	//Add Search to Edit Stage
	public static void showSearchForEdit() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/SearchForEdit.fxml"));
		BorderPane sfEdit = loader.load();
		/*Stage addDailogue = new Stage();
		addDailogue.setTitle("Search the Candidate to Edit");
		addDailogue.initModality(Modality.WINDOW_MODAL);
		addDailogue.initOwner(primaryStage);*/
		Scene scene = new Scene(sfEdit);
		addDailogue.setScene(scene);
		addDailogue.showAndWait();
	}
	
	public static void closeSearchForEdit() throws IOException {
		//addDailogue.hide();
		addDailogue.setScene(null);
		addDailogue.close();
		showWelcomePage();
	}
	
	public static void showEdit() throws IOException {
		addDailogue.setScene(null);
		addDailogue.close();
		BorderPane createnew = FXMLLoader.load(Main.class.getResource("view/EditPage.fxml"));
		mainLayout.setCenter(createnew);
		primaryStage.setResizable(true);
	}
	
	//Add Search for Delete Stage
	public static void showSearchForDelete() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/SearchForDelete.fxml"));
		BorderPane sfEdit = loader.load();
		Scene scene = new Scene(sfEdit);
		addDailogue.setScene(scene);
		addDailogue.showAndWait();
	}
	
	public static void closeSearchForDelete() throws IOException {
		//addDailogue.hide();
		addDailogue.setScene(null);
		addDailogue.close();
		showWelcomePage();
	}
	
	//show UploadCSV
	public static void showUploadCSVPage() throws IOException {
		BorderPane welcome = FXMLLoader.load(Main.class.getResource("view/UploadCSVPage.fxml"));
		mainLayout.setCenter(welcome);
		primaryStage.setResizable(false);
	}
	
	//show Developers details
	public static void showDevelopersPage() throws IOException {
		BorderPane welcome = FXMLLoader.load(Main.class.getResource("view/DevelopersPage.fxml"));
		mainLayout.setCenter(welcome);
		primaryStage.setResizable(false);
	}
	
	public static void onCancel() throws IOException {
		showWelcomePage();
	}
	
	public static void Log() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("LogPage.fxml"));
		BorderPane Log = loader.load();
		Scene scene = new Scene(Log);
		addLogPage.setScene(scene);
		addLogPage.show();
		logStatus = true;
	}
	
	public static void LogClose() {
		logStatus = false;
		addLogPage.setScene(null);
		addLogPage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
