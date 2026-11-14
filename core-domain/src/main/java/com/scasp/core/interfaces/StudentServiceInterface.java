package com.scasp.core.interfaces;

import com.scasp.core.Student;
import java.util.List;

public interface StudentServiceInterface {

    void addStudent(Student student);

    void removeStudent(Student student);

    List<Student> getAllStudents();

    int getTotalStudents();
}