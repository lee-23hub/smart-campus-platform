
package com.scasp.core.testing;

import com.scasp.core.Administrator;
import com.scasp.core.Announcement;
import com.scasp.core.AcademicRequest;
import com.scasp.core.Registration;
import java.time.LocalDate;
import com.scasp.core.Course;
import com.scasp.core.Student;
import com.scasp.core.integration.CoreDomainIntegration;
import java.util.List;

public class CoreDomainTest {

    public static void main(String[] args) {

        CoreDomainIntegration system =
                new CoreDomainIntegration();

        Student student = new Student(
                "NIPA001",
                "Test Student",
                "student@example.com",
                "Computer Science",
                3
        );
        
        
// Create a course
Course course = new Course(
        "C001",
        "Database Management",
        "CS301",
        4,
        50
);

// Add the course
system.getCourseService().addCourse(course);

// Retrieve all courses
System.out.println("Total courses: "
        + system.getCourseService().getTotalCourses());

for (Course c : system.getCourseService().getAllCourses()) {
    System.out.println("Course ID: " + c.getCourseId());
    System.out.println("Course Name: " + c.getCourseName());
    System.out.println("Course Code: " + c.getCourseCode());
}


// Create a registration
Registration registration = new Registration(
        "R001",
        student,
        course,
        LocalDate.now(),
        "Approved"
);

// Add registration
system.getRegistrationService().addRegistration(registration);

// Display registration details
System.out.println("Total registrations: "
        + system.getRegistrationService().getAllRegistrations().size());

System.out.println("Registration ID: "
        + registration.getRegistrationId());

System.out.println("Student: "
        + registration.getStudent().getFullName());

System.out.println("Course: "
        + registration.getCourse().getCourseName());

System.out.println("Status: "
        + registration.getStatus());


// Create an academic request
AcademicRequest request = new AcademicRequest(
        "AR001",
        student,
        "Transcript Request",
        "Request for an academic transcript",
        LocalDate.now(),
        "Pending"
);

// Add academic request
system.getRequestService().addRequest(request);

// Display request details
System.out.println("Total academic requests: "
        + system.getRequestService().getAllRequests().size());

System.out.println("Request ID: " + request.getRequestId());
System.out.println("Student: " + request.getStudent().getFullName());
System.out.println("Request Type: " + request.getRequestType());
System.out.println("Status: " + request.getStatus());


// Create an administrator
Administrator administrator = new Administrator(
        "ADM001",
        "System Administrator",
        "admin@example.com"
);

// Create an announcement
Announcement announcement = new Announcement(
        "AN001",
        "Semester Registration",
        "Semester registration is now open.",
        LocalDate.now(),
        administrator
);

// Add announcement
system.getAnnouncementService().addAnnouncement(announcement);

// Display announcement details
System.out.println("Total announcements: "
        + system.getAnnouncementService().getAllAnnouncements().size());

System.out.println("Announcement ID: "
        + announcement.getAnnouncementId());

System.out.println("Title: " + announcement.getTitle());

System.out.println("Message: " + announcement.getMessage());

System.out.println("Author: "
        + announcement.getAuthor().getFullName());




        system.getStudentService().addStudent(student);

        List<Student> students =
                system.getStudentService().getAllStudents();

        System.out.println("Total students: " + students.size());

        for (Student s : students) {
            System.out.println("Student ID: " + s.getStudentId());
            System.out.println("Full Name: " + s.getFullName());
            System.out.println("Programme: " + s.getProgramme());
        }
    }
}
