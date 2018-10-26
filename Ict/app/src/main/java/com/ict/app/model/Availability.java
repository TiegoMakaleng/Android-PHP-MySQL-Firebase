package com.ict.app.model;

public class Availability {
	
	private int statusId;
	private String status;
	private String date;
	private String time;
	private Lecturer lecturer;

	public Availability(int statusId, String status, String date, String time,
			Lecturer lecturer) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.date = date;
		this.time = time;
		this.lecturer = lecturer;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

}
