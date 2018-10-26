package com.ict.app.pojo;

public class LecturerAvailability {

	private String subjectCode;
	private String subjectName;
	private String course;
	private String department;
	private String registrationDate;
	private String lecturerName;
	private String availabilityStatus;
	private String availabilityDate;
	private String availabilityTime;

	public LecturerAvailability(String subjectCode, String subjectName,
			String course, String department, String registrationDate,
			String lecturerName, String availabilityStatus,
			String availabilityDate, String availabilityTime) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.course = course;
		this.department = department;
		this.registrationDate = registrationDate;
		this.lecturerName = lecturerName;
		this.availabilityStatus = availabilityStatus;
		this.availabilityDate = availabilityDate;
		this.availabilityTime = availabilityTime;
	}

	public LecturerAvailability(String subjectCode, String subjectName,
			String registrationDate, String lecturerName,
			String availabilityStatus, String availabilityDate,
			String availabilityTime) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.registrationDate = registrationDate;
		this.lecturerName = lecturerName;
		this.availabilityStatus = availabilityStatus;
		this.availabilityDate = availabilityDate;
		this.availabilityTime = availabilityTime;
	}

	public LecturerAvailability(String subjectCode, String subjectName,
			String lecturerName, String availabilityStatus,
			String availabilityDate, String availabilityTime) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.lecturerName = lecturerName;
		this.availabilityStatus = availabilityStatus;
		this.availabilityDate = availabilityDate;
		this.availabilityTime = availabilityTime;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public String getAvailabilityDate() {
		return availabilityDate;
	}

	public void setAvailabilityDate(String availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	public String getAvailabilityTime() {
		return availabilityTime;
	}

	public void setAvailabilityTime(String availabilityTime) {
		this.availabilityTime = availabilityTime;
	}

}
