
package com.scasp.core.services;

import com.scasp.core.Student;
import com.scasp.core.collections.StudentCollection;
import java.util.List;

public class StudentService {

    private final StudentCollection studentCollection;

    public StudentService(StudentCollection studentCollection) {
        this.studentCollection = studentCollection;
    }

    // Register a student
    public void addStudent(Student student) {
        studentCollection.addStudent(student);
    }

    // Remove a student
    public void removeStudent(Student student) {
        studentCollection.removeStudent(student);
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        return studentCollection.getStudents();
    }

    // Get total number of students
    public int getTotalStudents() {
        return studentCollection.getStudentCount();
    }
}
