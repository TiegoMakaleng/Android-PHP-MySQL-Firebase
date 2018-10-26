package com.ict.app.model;

import java.io.Serializable;

public class Diploma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private int id;
	private String code;
	private String name;
	private Staff diploma;
	private Department deparment;
	
	public Diploma() {
		super();
	}

	public Diploma(int id, String code, String name, Staff diploma,
			Department deparment) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.diploma = diploma;
		this.deparment = deparment;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Staff getDiploma() {
		return diploma;
	}
	public void setDiploma(Staff diploma) {
		this.diploma = diploma;
	}
	public Department getDeparment() {
		return deparment;
	}
	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
