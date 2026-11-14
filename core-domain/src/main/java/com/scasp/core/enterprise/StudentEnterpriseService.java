package com.scasp.core.enterprise;

import com.scasp.core.Student;
import com.scasp.core.interfaces.StudentServiceInterface;
import java.util.List;

public class StudentEnterpriseService {

    private final StudentServiceInterface studentService;

    public StudentEnterpriseService(
            StudentServiceInterface studentService) {
        this.studentService = studentService;
    }

    public void registerStudent(Student student) {
        studentService.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public int getTotalStudents() {
        return studentService.getTotalStudents();
    }
}