
package com.scasp.core.integration;

import com.scasp.core.collections.*;
import com.scasp.core.services.*;
import com.scasp.core.repositories.*;

public class CoreDomainIntegration {

    // Collections
    private final StudentCollection students = new StudentCollection();
    private final CourseCollection courses = new CourseCollection();
    private final RegistrationCollection registrations = new RegistrationCollection();
    private final AcademicRequestCollection requests = new AcademicRequestCollection();
    private final AnnouncementCollection announcements = new AnnouncementCollection();

    // Repositories
    private final StudentRepository studentRepository =
            new StudentRepository(students);

    private final CourseRepository courseRepository =
            new CourseRepository(courses);

    private final RegistrationRepository registrationRepository =
            new RegistrationRepository(registrations);

    private final AcademicRequestRepository requestRepository =
            new AcademicRequestRepository(requests);

    private final AnnouncementRepository announcementRepository =
            new AnnouncementRepository(announcements);

    // Services
    private final StudentService studentService =
            new StudentService(students);

    private final CourseService courseService =
            new CourseService(courses);

    private final RegistrationService registrationService =
            new RegistrationService(registrations);

    private final AcademicRequestService requestService =
            new AcademicRequestService(requests);

    private final AnnouncementService announcementService =
            new AnnouncementService(announcements);

    public StudentService getStudentService() {
        return studentService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public AcademicRequestService getRequestService() {
        return requestService;
    }

    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }
}
