package com.scasp.core.interfaces;


import com.scasp.core.Course;
import java.util.List;

public interface CourseServiceInterface {

    void addCourse(Course course);

    void removeCourse(Course course);

    List<Course> getAllCourses();

    int getTotalCourses();
}