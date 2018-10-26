package com.ict.app.model;

import java.io.Serializable;

public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private int id;
	private String code;
	private String name;
	private double fee;
	private Staff head;
	private Diploma diploma;
	private String prerequisite;
	
	public Subject() {
	}

	public Subject(int id, String code, String name, double fee, Staff head,
			Diploma diploma, String prerequisite) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.fee = fee;
		this.head = head;
		this.diploma = diploma;
		this.prerequisite = prerequisite;
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

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Staff getHead() {
		return head;
	}

	public void setHead(Staff head) {
		this.head = head;
	}

	public Diploma getDiploma() {
		return diploma;
	}

	public void setDiploma(Diploma diploma) {
		this.diploma = diploma;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

}
