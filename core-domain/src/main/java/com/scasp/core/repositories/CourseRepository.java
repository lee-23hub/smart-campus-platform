
package com.scasp.core.repositories;

import com.scasp.core.Course;
import com.scasp.core.collections.CourseCollection;
import java.util.List;

public class CourseRepository {

    private final CourseCollection courseCollection;

    public CourseRepository(CourseCollection courseCollection) {
        this.courseCollection = courseCollection;
    }

    // Save a course
    public void save(Course course) {
        courseCollection.addCourse(course);
    }

    // Delete a course
    public void delete(Course course) {
        courseCollection.removeCourse(course);
    }

    // Find all courses
    public List<Course> findAll() {
        return courseCollection.getCourses();
    }

    // Count courses
    public int count() {
        return courseCollection.getCourseCount();
    }
}
