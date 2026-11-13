
package com.scasp.core;

import java.time.LocalDate;

public class Registration {

    private String registrationId;
    private Student student;
    private Course course;
    private LocalDate registrationDate;
    private String status;

    public Registration(String registrationId, Student student,
                        Course course, LocalDate registrationDate,
                        String status) {
        this.registrationId = registrationId;
        this.student = student;
        this.course = course;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
