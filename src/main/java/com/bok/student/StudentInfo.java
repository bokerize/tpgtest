package com.bok.student;

/**
 * Created by JerichoJohn on 13-Aug-17.
 */
public class StudentInfo {

    private Long id;
    private String firstName;
    private Double gpa;

    public StudentInfo() {
    }

    public StudentInfo(Long id, String firstName, Double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.gpa = gpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return String.format("student:  %s, %s, %s ", id, firstName, gpa);
    }


}
