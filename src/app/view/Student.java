package app.view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Student {
	private Manage mg;
	private final SimpleStringProperty name;
	private final SimpleStringProperty usn;
	private final SimpleStringProperty email;
	private final SimpleStringProperty phone;
	private final SimpleStringProperty gender;
	private final SimpleStringProperty dob;
	private final SimpleDoubleProperty marks10th;
	private final SimpleDoubleProperty marks12th;
	private final SimpleDoubleProperty totalMarks;
	private final SimpleDoubleProperty Aggregate;
	private final SimpleStringProperty pLanguages;
	private final SimpleStringProperty pTools;
	private final SimpleStringProperty spec1;
	private final SimpleStringProperty spec2;
	private final SimpleStringProperty spec3;
	private final SimpleStringProperty branch;
	private final SimpleIntegerProperty bcklg;
	private final SimpleStringProperty resumeFileName;
	private final CheckBox checkbox;
	//private final Button resumeBtn;
	public Student(String name, String usn, String email, String phone, String gender, String dob, double marks10th,
			double marks12th, double totalMarks, double aggregate,String branch, int bcklg, String pLanguages, String pTools, String spec1,
			String spec2, String spec3, String resumeFileName) {
		super();
		this.name = new SimpleStringProperty(name);
		this.usn = new SimpleStringProperty(usn);
		this.email = new SimpleStringProperty(email);
		this.phone = new SimpleStringProperty(phone);
		this.gender = new SimpleStringProperty(gender);
		this.dob = new SimpleStringProperty(dob);
		this.marks10th = new SimpleDoubleProperty(marks10th);
		this.marks12th = new SimpleDoubleProperty(marks12th);
		this.totalMarks = new SimpleDoubleProperty(totalMarks);
		Aggregate = new SimpleDoubleProperty(aggregate);
		this.branch = new SimpleStringProperty(branch);
		this.bcklg = new SimpleIntegerProperty(bcklg);
		this.pLanguages = new SimpleStringProperty(pLanguages);
		this.pTools = new SimpleStringProperty(pTools);
		this.spec1 = new SimpleStringProperty(spec1);
		this.spec2 = new SimpleStringProperty(spec2);
		this.spec3 = new SimpleStringProperty(spec3);
		this.checkbox = new CheckBox();
		this.resumeFileName = new SimpleStringProperty(resumeFileName);
		/*this.resumeBtn = new Button("Resume");
		resumeBtn.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent actionEvent) {
	        	System.out.println("rakesh on set Action");
		        }
		      });*/
	}
	public String getName() {
		return name.get();
	}
	public String getUsn() {
		return usn.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getPhone() {
		return phone.get();
	}
	public String getGender() {
		return gender.get();
	}
	public String getDob() {
		return dob.get();
	}
	public double getMarks10th() {
		return marks10th.get();
	}
	public double getMarks12th() {
		return marks12th.get();
	}
	public double getTotalMarks() {
		return totalMarks.get();
	}
	public double getAggregate() {
		return Aggregate.get();
	}
	public String getBranch() {
		return branch.get();
	}
	public int getBcklg() {
		return bcklg.get();
	}
	public String getpLanguages() {
		return pLanguages.get();
	}
	public String getpTools() {
		return pTools.get();
	}
	public String getSpec1() {
		return spec1.get();
	}
	public String getSpec2() {
		return spec2.get();
	}
	public String getSpec3() {
		return spec3.get();
	}
	public CheckBox getCheckbox() {
		return checkbox;
	}
	/*public Button getResumeBtn() {
		return resumeBtn;
	}*/
	public String getResumeFileName() {
		return resumeFileName.get();
	}
}
