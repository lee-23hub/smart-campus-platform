package com.scasp.application.controllers;

import com.scasp.core.Registration;
import com.scasp.core.services.RegistrationService;
import java.util.List;

public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // Add a registration
    public void addRegistration(Registration registration) {
        registrationService.addRegistration(registration);
    }

    // Retrieve all registrations
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    // Get total registrations
    public int getTotalRegistrations() {
        return registrationService.getAllRegistrations().size();
    }
}