package com.scasp.application.integration;

import com.scasp.core.integration.CoreDomainIntegration;
import com.scasp.application.controllers.*;

public class ApplicationIntegration {

    private final CoreDomainIntegration coreDomain =
            new CoreDomainIntegration();

    private final StudentController studentController =
            new StudentController(coreDomain.getStudentService());

    private final CourseController courseController =
            new CourseController(coreDomain.getCourseService());

    private final RegistrationController registrationController =
            new RegistrationController(coreDomain.getRegistrationService());

    private final AcademicRequestController requestController =
            new AcademicRequestController(coreDomain.getRequestService());

    private final AnnouncementController announcementController =
            new AnnouncementController(coreDomain.getAnnouncementService());

    public StudentController getStudentController() {
        return studentController;
    }

    public CourseController getCourseController() {
        return courseController;
    }

    public RegistrationController getRegistrationController() {
        return registrationController;
    }

    public AcademicRequestController getRequestController() {
        return requestController;
    }

    public AnnouncementController getAnnouncementController() {
        return announcementController;
    }
}