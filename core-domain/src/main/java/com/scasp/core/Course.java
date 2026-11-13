
package com.scasp.core;

public class Course {

    private String courseId;
    private String courseName;
    private String courseCode;
    private int creditHours;
    private int capacity;

    public Course(String courseId, String courseName,
                  String courseCode, int creditHours,
                  int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.capacity = capacity;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
