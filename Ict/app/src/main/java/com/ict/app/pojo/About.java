package com.ict.app.pojo;

/**
 * Created by Student on 2017-10-29.
 */

public class About {

    private String faculty;
    private String department;
    private String developer;
    private String year;

    public About(String faculty, String department, String developer, String year) {
        this.faculty = faculty;
        this.department = department;
        this.developer = developer;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
