
package com.scasp.core.database;

import com.scasp.core.Student;
import com.scasp.core.Course;
import com.scasp.core.Administrator;
import com.scasp.core.Registration;
import com.scasp.core.AcademicRequest;
import com.scasp.core.Announcement;

import com.scasp.core.repositories.*;

import java.time.LocalDate;

public class JdbcRepositoryTest {

    public static void main(String[] args) {

        String id = "TEST-" + System.currentTimeMillis();

        try {
            // Create repositories
            JdbcStudentRepository studentRepo =
                    new JdbcStudentRepository();

            JdbcCourseRepository courseRepo =
                    new JdbcCourseRepository();

            JdbcAdministratorRepository adminRepo =
                    new JdbcAdministratorRepository();

            JdbcRegistrationRepository registrationRepo =
                    new JdbcRegistrationRepository();

            JdbcAcademicRequestRepository requestRepo =
                    new JdbcAcademicRequestRepository();

            JdbcAnnouncementRepository announcementRepo =
                    new JdbcAnnouncementRepository();

            // Create student
            Student student = new Student(
                    id,
                    "Test Student",
                    id + "@example.com",
                    "Computer Science",
                    3
            );

            studentRepo.save(student);

            // Create course
            Course course = new Course(
                    id,
                    "Database Systems",
                    id,
                    3,
                    50
            );

            courseRepo.save(course);

            // Create administrator
            Administrator admin = new Administrator(
                    id,
                    "Test Administrator",
                    id + "@admin.example.com"
            );

            adminRepo.save(admin);

            // Create registration
            Registration registration = new Registration(
                    id,
                    student,
                    course,
                    LocalDate.now(),
                    "Pending"
            );

            registrationRepo.save(registration);

            // Create academic request
            AcademicRequest request = new AcademicRequest(
                    id,
                    student,
                    "Transcript Request",
                    "Test academic request",
                    LocalDate.now(),
                    "Pending"
            );

            requestRepo.save(request);

            // Create announcement
            Announcement announcement = new Announcement(
                    id,
                    "Test Announcement",
                    "This is a database integration test.",
                    LocalDate.now(),
                    admin
            );

            announcementRepo.save(announcement);

            // Display results
            System.out.println("JDBC REPOSITORY TEST RESULTS");
            System.out.println("----------------------------");

            System.out.println("Students: " + studentRepo.count());
            System.out.println("Courses: " + courseRepo.count());
            System.out.println("Administrators: " + adminRepo.count());
            System.out.println("Registrations: " + registrationRepo.count());
            System.out.println("Academic Requests: " + requestRepo.count());
            System.out.println("Announcements: " + announcementRepo.count());

            System.out.println("----------------------------");
            System.out.println("ALL REPOSITORY TESTS COMPLETED.");

        } catch (Exception e) {

            System.out.println("REPOSITORY TEST FAILED!");
            e.printStackTrace();
        }
    }
}
