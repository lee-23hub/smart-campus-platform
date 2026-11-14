package com.scasp.core.enterprise;

import com.scasp.core.Course;
import com.scasp.core.interfaces.CourseServiceInterface;
import java.util.List;

public class CourseEnterpriseService {

    private final CourseServiceInterface courseService;

    public CourseEnterpriseService(
            CourseServiceInterface courseService) {
        this.courseService = courseService;
    }

    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    public int getTotalCourses() {
        return courseService.getTotalCourses();
    }
}