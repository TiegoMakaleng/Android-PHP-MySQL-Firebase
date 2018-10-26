package com.ict.app.pojo;

public class LecturerProfile {

	private String lecturerName;
	private String lecturerOfficeNo;

	public LecturerProfile(String lecturerName, String lecturerOfficeNo) {
		super();
		this.lecturerName = lecturerName;
		this.lecturerOfficeNo = lecturerOfficeNo;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getLecturerOfficeNo() {
		return lecturerOfficeNo;
	}

	public void setLecturerOfficeNo(String lecturerOfficeNo) {
		this.lecturerOfficeNo = lecturerOfficeNo;
	}

}
