
package com.scasp.core.repositories;

import com.scasp.core.interfaces.StudentRepositoryInterface;
import com.scasp.core.Student;
import com.scasp.core.collections.StudentCollection;
import java.util.List;

public class StudentRepository implements StudentRepositoryInterface {

    private final StudentCollection studentCollection;

    public StudentRepository(StudentCollection studentCollection) {
        this.studentCollection = studentCollection;
    }

    // Save a student
    public void save(Student student) {
        studentCollection.addStudent(student);
    }

    // Delete a student
    public void delete(Student student) {
        studentCollection.removeStudent(student);
    }

    // Find all students
    public List<Student> findAll() {
        return studentCollection.getStudents();
    }

    // Count students
    public int count() {
        return studentCollection.getStudentCount();
    }
}
