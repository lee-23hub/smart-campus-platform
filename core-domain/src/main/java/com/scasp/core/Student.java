
package com.scasp.core;

public class Student {

    // Student attributes
    private String studentId;
    private String fullName;
    private String email;
    private String programme;
    private int yearOfStudy;

    // Constructor
    public Student(String studentId, String fullName,
                   String email, String programme,
                   int yearOfStudy) {

        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.programme = programme;
        this.yearOfStudy = yearOfStudy;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getProgramme() {
        return programme;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    // Setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
