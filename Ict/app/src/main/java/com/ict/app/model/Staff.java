package com.ict.app.model;

public class Staff {
	
	private int number;
	private String surname;
	private String initials;
	private String officeNumber;
	private String jobDescription;
	private double salary;
	private double bonus;

	public Staff(int number, String surname, String initials,
			String officeNumber, String jobDescription, double salary,
			double bonus) {
		super();
		this.number = number;
		this.surname = surname;
		this.initials = initials;
		this.officeNumber = officeNumber;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.bonus = bonus;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
