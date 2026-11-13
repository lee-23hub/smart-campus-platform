package com.scasp.application;

import com.scasp.core.integration.CoreDomainIntegration;

public class SmartCampusApplication {

    public static void main(String[] args) {

        CoreDomainIntegration system =
                new CoreDomainIntegration();

        System.out.println("================================");
        System.out.println("   SMART CAMPUS PLATFORM");
        System.out.println("================================");

        System.out.println("Application started successfully!");

        System.out.println("Total students: "
                + system.getStudentService().getAllStudents().size());

        System.out.println("Total courses: "
                + system.getCourseService().getTotalCourses());

        System.out.println("================================");
    }
}