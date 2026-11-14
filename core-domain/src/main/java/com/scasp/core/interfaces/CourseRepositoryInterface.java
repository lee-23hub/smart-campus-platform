package com.scasp.core.interfaces;

import com.scasp.core.Course;
import java.util.List;

public interface CourseRepositoryInterface {

    void save(Course course);

    void delete(Course course);

    List<Course> findAll();

    int count();
}