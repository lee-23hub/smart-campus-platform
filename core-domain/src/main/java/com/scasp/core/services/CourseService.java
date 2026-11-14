
package com.scasp.core.services;

import com.scasp.core.interfaces.CourseServiceInterface;
import com.scasp.core.Course;
import com.scasp.core.collections.CourseCollection;
import java.util.List;

public class CourseService implements CourseServiceInterface {

    private final CourseCollection courseCollection;

    public CourseService(CourseCollection courseCollection) {
        this.courseCollection = courseCollection;
    }

    // Add a course
    public void addCourse(Course course) {
        courseCollection.addCourse(course);
    }

    // Remove a course
    public void removeCourse(Course course) {
        courseCollection.removeCourse(course);
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseCollection.getCourses();
    }

    // Get total number of courses
    public int getTotalCourses() {
        return courseCollection.getCourseCount();
    }
}
