package com.scasp.core.collections;

import com.scasp.core.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseCollection {

    private final List<Course> courses = new ArrayList<>();

    // Add a course
    public synchronized void addCourse(Course course) {
        courses.add(course);
    }

    // Remove a course
    public synchronized void removeCourse(Course course) {
        courses.remove(course);
    }

    // Get all courses
    public synchronized List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    // Get total number of courses
    public synchronized int getCourseCount() {
        return courses.size();
    }

    // Check if collection is empty
    public synchronized boolean isEmpty() {
        return courses.isEmpty();
    }
}