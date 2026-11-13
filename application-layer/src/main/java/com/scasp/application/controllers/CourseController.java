package com.scasp.application.controllers;

import com.scasp.core.Course;
import com.scasp.core.services.CourseService;
import java.util.List;

public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Add a course
    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Get total number of courses
    public int getTotalCourses() {
        return courseService.getTotalCourses();
    }
}