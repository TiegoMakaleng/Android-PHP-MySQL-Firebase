package com.ict.app.pojo;

public class StudentProfile {

	private String studentSurname;
	private String studentInitials;
	private String studentGender;
	private String studentBirthdate;
	
	public StudentProfile(String studentSurname, String studentInitials,
			String studentGender, String studentBirthdate) {
		super();
		this.studentSurname = studentSurname;
		this.studentInitials = studentInitials;
		this.studentGender = studentGender;
		this.studentBirthdate = studentBirthdate;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public String getStudentInitials() {
		return studentInitials;
	}

	public void setStudentInitials(String studentInitials) {
		this.studentInitials = studentInitials;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentBirthdate() {
		return studentBirthdate;
	}

	public void setStudentBirthdate(String studentBirthdate) {
		this.studentBirthdate = studentBirthdate;
	}
	
}
