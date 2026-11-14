
package com.scasp.core.services;

import com.scasp.core.interfaces.RegistrationServiceInterface;
import com.scasp.core.Registration;
import com.scasp.core.collections.RegistrationCollection;
import java.util.List;

public class RegistrationService implements RegistrationServiceInterface {

    private final RegistrationCollection registrationCollection;

    public RegistrationService(RegistrationCollection registrationCollection) {
        this.registrationCollection = registrationCollection;
    }

    // Add a registration
    public void addRegistration(Registration registration) {
        registrationCollection.addRegistration(registration);
    }

    // Remove a registration
    public void removeRegistration(Registration registration) {
        registrationCollection.removeRegistration(registration);
    }

    // Retrieve all registrations
    public List<Registration> getAllRegistrations() {
        return registrationCollection.getRegistrations();
    }

    // Get total registrations
    public int getTotalRegistrations() {
        return registrationCollection.getRegistrationCount();
    }
}
