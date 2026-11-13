
package com.scasp.core.collections;

import com.scasp.core.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseCollection {

    private final List<Course> courses = new ArrayList<>();

    // Add a course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Remove a course
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    // Get all courses
    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    // Get total number of courses
    public int getCourseCount() {
        return courses.size();
    }

    // Check if collection is empty
    public boolean isEmpty() {
        return courses.isEmpty();
    }
}
