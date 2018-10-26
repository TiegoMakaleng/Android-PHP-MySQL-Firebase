package com.ict.app.model;

public class Faculty {
	
	private int id;
	private String code;
	private String name;
	private String head;
	
	public Faculty() {
	}

	public Faculty(int id, String code, String name, String head) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.head = head;
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

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

}
