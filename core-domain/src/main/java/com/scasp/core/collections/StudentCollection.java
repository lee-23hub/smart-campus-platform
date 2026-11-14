package com.scasp.core.collections;

import com.scasp.core.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentCollection {

    private final List<Student> students = new ArrayList<>();

    // Add a student
    public synchronized void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student
    public synchronized void removeStudent(Student student) {
        students.remove(student);
    }

    // Get all students
    public synchronized List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    // Get total number of students
    public synchronized int getStudentCount() {
        return students.size();
    }

    // Check if the collection is empty
    public synchronized boolean isEmpty() {
        return students.isEmpty();
    }
}