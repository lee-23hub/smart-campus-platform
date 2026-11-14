
package com.scasp.core.database;

import com.scasp.core.Student;
import com.scasp.core.repositories.JdbcStudentRepository;

public class JdbcStudentTest {

    public static void main(String[] args) {

        JdbcStudentRepository repository =
                new JdbcStudentRepository();

        String id = "JDBC-" + System.currentTimeMillis();

        Student student = new Student(
                id,
                "Test Student",
                id + "@example.com",
                "Computer Science",
                3
        );

        try {
            // Save student to MySQL
            repository.save(student);

            System.out.println("Student saved successfully!");

            // Display all students
            System.out.println("Total students: "
                    + repository.count());

            // Retrieve students
            for (Student s : repository.findAll()) {
                System.out.println(
                        s.getStudentId() + " - "
                        + s.getFullName()
                );
            }

        } catch (RuntimeException e) {
            System.out.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
