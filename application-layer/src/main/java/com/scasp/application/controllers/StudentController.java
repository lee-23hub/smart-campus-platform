package com.scasp.application.controllers;

import com.scasp.core.Student;
import com.scasp.core.services.StudentService;
import java.util.List;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Add a student
    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get total number of students
    public int getTotalStudents() {
        return studentService.getAllStudents().size();
    }
}