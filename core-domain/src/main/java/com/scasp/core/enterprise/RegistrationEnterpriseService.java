package com.scasp.core.enterprise;

import com.scasp.core.Registration;
import com.scasp.core.interfaces.RegistrationServiceInterface;
import java.util.List;

public class RegistrationEnterpriseService {

    private final RegistrationServiceInterface registrationService;

    public RegistrationEnterpriseService(
            RegistrationServiceInterface registrationService) {
        this.registrationService = registrationService;
    }

    public void addRegistration(Registration registration) {
        registrationService.addRegistration(registration);
    }

    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    public int getTotalRegistrations() {
        return registrationService.getTotalRegistrations();
    }
}