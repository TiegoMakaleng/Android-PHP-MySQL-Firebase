package com.ict.app.pojo;

import android.graphics.Bitmap;

public class StudentSubject {

	private int id;
	private String subjCode;
	private String subjName;
	private String dipName;
	private String department;
	private String status;
	private String statusUrl;
	private Bitmap bitmap;

	public StudentSubject(int id, String subjCode, String subjName, String dipName, String department, String status, String statusUrl) {
		this.id = id;
		this.subjCode = subjCode;
		this.subjName = subjName;
		this.dipName = dipName;
		this.department = department;
		this.status = status;
		this.statusUrl = statusUrl;
	}

	public StudentSubject(String subjCode, String subjName, String dipName, String department, String status, String statusUrl) {
		this.subjCode = subjCode;
		this.subjName = subjName;
		this.dipName = dipName;
		this.department = department;
		this.status = status;
		this.statusUrl = statusUrl;
	}

	public StudentSubject(String subjCode, String subjName, String dipName, String department, String statusUrl, Bitmap bitmap) {
		this.subjCode = subjCode;
		this.subjName = subjName;
		this.dipName = dipName;
		this.department = department;
		this.statusUrl = statusUrl;
		this.bitmap = bitmap;
	}

	public StudentSubject(String subjCode, String subjName, String dipName,
						  String department) {
		super();
		this.subjCode = subjCode;
		this.subjName = subjName;
		this.dipName = dipName;
		this.department = department;
	}

	public String getSubjCode() {
		return subjCode;
	}

	public void setSubjCode(String subjCode) {
		this.subjCode = subjCode;
	}

	public String getSubjName() {
		return subjName;
	}

	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}

	public String getDipName() {
		return dipName;
	}

	public void setDipName(String dipName) {
		this.dipName = dipName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatusUrl() {
		return statusUrl;
	}

	public void setStatusUrl(String statusUrl) {
		this.statusUrl = statusUrl;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
