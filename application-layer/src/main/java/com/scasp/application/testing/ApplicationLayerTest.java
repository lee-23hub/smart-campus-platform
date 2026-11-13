package com.scasp.application.testing;

import com.scasp.core.Student;
import com.scasp.core.Course;
import com.scasp.core.Registration;
import com.scasp.core.integration.CoreDomainIntegration;
import com.scasp.application.integration.ApplicationIntegration;
import java.time.LocalDate;

public class ApplicationLayerTest {

    public static void main(String[] args) {

        ApplicationIntegration system =
                new ApplicationIntegration();

        System.out.println("================================");
        System.out.println(" APPLICATION LAYER TEST");
        System.out.println("================================");

        // Test Student Controller
        Student student = new Student(
                "NIPA002",
                "Application Test Student",
                "test@example.com",
                "Computer Science",
                3
        );

        system.getStudentController().addStudent(student);

        System.out.println("Total students: "
                + system.getStudentController().getTotalStudents());

        // Test Course Controller
        Course course = new Course(
                "C002",
                "Software Engineering",
                "CS302",
                4,
                40
        );

        system.getCourseController().addCourse(course);

        System.out.println("Total courses: "
                + system.getCourseController().getTotalCourses());

        // Test Registration Controller
        Registration registration = new Registration(
                "R002",
                student,
                course,
                LocalDate.now(),
                "Pending"
        );

        system.getRegistrationController()
                .addRegistration(registration);

        System.out.println("Total registrations: "
                + system.getRegistrationController()
                        .getTotalRegistrations());

        System.out.println("================================");
        System.out.println("APPLICATION TEST COMPLETED");
        System.out.println("================================");
    }
}