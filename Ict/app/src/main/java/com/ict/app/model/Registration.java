package com.ict.app.model;

import java.io.Serializable;

public class Registration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private int id;
	private Student student;
	private Subject subject;
	private String date;
	private String campus;
	private int mark;

	public Registration(int id, Student student, Subject subject, String date,
			String campus, int mark) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.date = date;
		this.campus = campus;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

}
