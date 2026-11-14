package com.scasp.core.testing;

import com.scasp.core.Student;
import com.scasp.core.collections.StudentCollection;

public class ConcurrencyTest {

    public static void main(String[] args) {

        StudentCollection students = new StudentCollection();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                Student student = new Student(
    "STU" + Thread.currentThread().threadId() + "-" + i,
    "Test",
    "Student",
    "test" + Thread.currentThread().threadId() + i + "@example.com",
    1
);
                students.addStudent(student);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Test interrupted.");
            return;
        }

        System.out.println("Total students added: "
                + students.getStudentCount());
    }
}