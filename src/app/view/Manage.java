package app.view;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import app.Main;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Manage implements Initializable{
	private static Main main;
	static String Item;
	public String TEMP,T1,T2,T3,Line;
	static boolean isMarks=false;
	static String Name="";
	static String Email="";
	static boolean IsBcklg=false;
	static int MaxBcklg=0;
	static Double M10=(double) 0;
	static Double M12=(double) 0;
	static Double aggt=(double) 0;
	static String branch="";
	static String Spec ="";
	@FXML TableView<Student> SRtableView;
    public static ObservableList<Student> list = FXCollections.observableArrayList();
    public static ObservableList<Student> dataListRemove = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Search Successfull");
		}
		InitTable();		
	}
	@SuppressWarnings("unchecked")
	private void InitTable() {
		TableColumn<Student, String> name = new TableColumn<>("Name");
		TableColumn<Student, String> usn = new TableColumn<>("USN");
		TableColumn<Student, String> email = new TableColumn<>("Email");
		TableColumn<Student, String> phone = new TableColumn<>("Phone");
		TableColumn<Student, String> gender = new TableColumn<>("Gender");
		TableColumn<Student, String> dob = new TableColumn<>("DOB");
		TableColumn<Student, Double> marks10th = new TableColumn<>("10th");
		TableColumn<Student, Double> marks12th = new TableColumn<>("12th");
		TableColumn<Student, Double> tmarks = new TableColumn<>("Total");
		TableColumn<Student, Double> agg = new TableColumn<>("Aggregate");
		TableColumn<Student, String> pl = new TableColumn<>("PL");
		TableColumn<Student, String> pt = new TableColumn<>("PT");
		TableColumn<Student, String> sp1 = new TableColumn<>("SP1");
		TableColumn<Student, String> sp2 = new TableColumn<>("SP2");
		TableColumn<Student, String> sp3 = new TableColumn<>("SP3");
		TableColumn<Student, String> branch = new TableColumn<>("Branch");
		TableColumn<Student, Integer> bcklg = new TableColumn<>("Backlogs");
		TableColumn<Student, String> select = new TableColumn<>("Action");
		TableColumn<Student, String> resumeBtn = new TableColumn<>("Resume");
		
		name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		usn.setCellValueFactory(new PropertyValueFactory<Student, String>("usn"));
		email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
		phone.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
		gender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
		dob.setCellValueFactory(new PropertyValueFactory<Student, String>("dob"));
		marks10th.setCellValueFactory(new PropertyValueFactory<Student, Double>("marks10th"));
		marks12th.setCellValueFactory(new PropertyValueFactory<Student, Double>("marks12th"));
		tmarks.setCellValueFactory(new PropertyValueFactory<Student, Double>("totalMarks"));
		agg.setCellValueFactory(new PropertyValueFactory<Student, Double>("aggregate"));
		pl.setCellValueFactory(new PropertyValueFactory<Student, String>("pLanguages"));
		pt.setCellValueFactory(new PropertyValueFactory<Student, String>("pTools"));
		sp1.setCellValueFactory(new PropertyValueFactory<Student, String>("spec1"));
		sp2.setCellValueFactory(new PropertyValueFactory<Student, String>("spec2"));
		sp3.setCellValueFactory(new PropertyValueFactory<Student, String>("spec3"));
		branch.setCellValueFactory(new PropertyValueFactory<Student, String>("branch"));
		bcklg.setCellValueFactory(new PropertyValueFactory<Student, Integer>("bcklg"));
		select.setCellValueFactory(new PropertyValueFactory<Student, String>("checkbox"));
		//resumeBtn.setCellValueFactory(new PropertyValueFactory<Student, String>("resumeBtn"));
		/*resumeBtn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Boolean>, ObservableValue<Boolean>>() {
		      @Override public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, Boolean> features) {
		        return new SimpleBooleanProperty(features.getValue() != null);
		      }
		    });
		resumeBtn.setCellFactory(new Callback<TableColumn<Student, Boolean>, TableCell<Student, Boolean>>() {
		      @Override public TableCell<Person, Boolean> call(TableColumn<Person, Boolean> personBooleanTableColumn) {
		          return new AddPersonCell(stage, table);
		        }
		      });*/
		
		SRtableView.getColumns().addAll(select,name,usn,branch,email,phone,gender,dob,marks10th,marks12th,tmarks,agg,bcklg,sp1);
		SRtableView.setItems(list);
		/*Button r = null;
		r.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent actionEvent) {
	          Student x = SRtableView.getSelectionModel().getSelectedItem();
	        }
	      });*/
		
	}
	@SuppressWarnings("static-access")
	public void Home() throws IOException {
		main.showWelcomePage();
	}
	@SuppressWarnings("static-access")
	public void Back() throws IOException {
		main.searchPageHome();
	}
	
	@SuppressWarnings("static-access")
	public void getData() throws IOException {
		String[] LineItems;
		boolean Flag;
		try {
			list.clear();
			BufferedReader bb=new BufferedReader(new FileReader(main.RecFile));
			while((Line=bb.readLine())!=null) {
				//System.out.println(Line);
				Flag=false;
				LineItems = Line.split("#");
				T1=LineItems[0].toUpperCase();
				if(T1.startsWith(Name.toUpperCase())) {
					T1=LineItems[2].toUpperCase();
					if(T1.startsWith(Email.toUpperCase())) {
							if(Double.parseDouble(LineItems[6])>=M10) {
								if(Double.parseDouble(LineItems[7])>=M12) {
									if(Double.parseDouble(LineItems[9])>=aggt) {
										if(LineItems[10].startsWith(branch)) {
											System.out.println(LineItems[10]);
											if(Integer.parseInt(LineItems[11])<=MaxBcklg) {
												T1=LineItems[14].toUpperCase();
												T2=LineItems[15].toUpperCase();
												T3=LineItems[16].toUpperCase();
												if(T1.startsWith(Spec.toUpperCase())|T2.startsWith(Spec.toUpperCase())|T3.startsWith(Spec.toUpperCase())) {
													String[] fields = Line.split("#");
													System.out.println(Line);
													Student record = new Student(fields[0], fields[1],fields[2],fields[3],fields[4],fields[5],Double.parseDouble(fields[6]),Double.parseDouble(fields[7]),Double.parseDouble(fields[8]),Double.parseDouble(fields[9]),fields[10],Integer.parseInt(fields[11]),fields[12],fields[13],fields[14],fields[15],fields[16],fields[17]);
									                list.add(record);
									                //System.out.println("list added "+record.getpLanguages()+"-"+record.getpTools());
									                Flag=true;
												}
											}
										}
									}
								}
							}
					}
				}
			}
			bb.close();
		}catch(Exception e) {
			System.out.println("Error in File Access - A small exception Occured \n"+e);
		}finally {
			System.out.println("Success");
		}
	}
	static void getString(String name,String email,Double m10,Double m12,Double aggr,boolean isBcklg,String branchtemp,int maxBcklg,String spec) {
		Item=name;
		System.out.println(branchtemp);//name+email+m10.toString()+m12.toString()+
		if(m10!=0 || m12!=0) {
			isMarks=true;
			M10=m10;
			M12=m12;
		}
		Name=name;
		Email=email;
		branch=branchtemp;
		IsBcklg=isBcklg;
		MaxBcklg=maxBcklg;
		Spec=spec;
		aggt=aggr;
	}
	@FXML
    private void deleteSelectedRows() {
		@SuppressWarnings("static-access")
		File Original = new File(main.RecFile);
		@SuppressWarnings("static-access")
		File Modified = new File(main.TempFile);
        for(Student bean : list) {
           if(bean.getCheckbox().isSelected()) {
        	   System.out.println(bean);
               dataListRemove.add(bean);
           }
        }
        list.removeAll(dataListRemove);
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(Original));
    		BufferedWriter writer = new BufferedWriter(new FileWriter(Modified));
        	//for(Student x: dataListRemove) {
        		boolean f=false;
        		String currentLine;
        		while((currentLine = reader.readLine()) != null) {
        		    String trimmedLine = currentLine.trim();
        		    for(Student x: dataListRemove) {
        		    	Student DelItem = x;
                		if(DelItem==null) return;
                		String DelT=DelItem.getName()+"#"+DelItem.getUsn()+"#"+DelItem.getEmail()+"#"+DelItem.getPhone();
                		System.out.println("Selected Item is : "+DelT);
                		String lineToRemove = DelT;
                		lineToRemove=DelT.trim();
	        		    if(trimmedLine.contains(lineToRemove))
	        		    	{
	        		    		System.out.println("\nDeleted "+x.getName());
	        		    		dataListRemove.remove(x);
	        		    		f=true;
	        		    		break;
	        		    	}
	        		    }
        		    if(f) {
        		    	f=false;
        		    	continue;
        		    }
        		    writer.write(currentLine + System.getProperty("line.separator"));
        		}
        	//}
    		writer.close(); 
    		reader.close();
        }catch(Exception e) {
        	System.out.println("\n\nAn Error Occured : "+e);
        }
        boolean successful = Original.delete();
        if(successful)
        	Modified.renameTo(Original);
    }
	//------------
	@FXML
	public void openResume() throws IOException {
		File selectedFile = null;
		Student x = SRtableView.getSelectionModel().getSelectedItem();
		if(x!=null) {
			String name = x.getName();
			String fname = x.getResumeFileName();
			String fpath = main.dirname+"PDFresumes\\"+fname;
			Path y = Paths.get(fpath);
			selectedFile = y.toFile();
			System.out.println("Opening the Resume of: "+name);
			if(selectedFile != null) {
				Desktop.getDesktop().open(new File(selectedFile.getAbsolutePath()));
			}
			else {
				System.out.println("Can't open file");
			}
		}else {
			System.out.println("Select any Row");
		}
	}
	
}

