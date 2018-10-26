package com.ict.app.model;

import java.io.Serializable;

public class Lecturer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private int id;
	private Subject subject;
	private Staff staff;

	public Lecturer(int id, Subject subject, Staff staff) {
		super();
		this.id = id;
		this.subject = subject;
		this.staff = staff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
