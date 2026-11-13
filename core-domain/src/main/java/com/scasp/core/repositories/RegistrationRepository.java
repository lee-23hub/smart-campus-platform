
package com.scasp.core.repositories;

import com.scasp.core.Registration;
import com.scasp.core.collections.RegistrationCollection;
import java.util.List;

public class RegistrationRepository {

    private final RegistrationCollection registrationCollection;

    public RegistrationRepository(RegistrationCollection registrationCollection) {
        this.registrationCollection = registrationCollection;
    }

    // Save a registration
    public void save(Registration registration) {
        registrationCollection.addRegistration(registration);
    }

    // Delete a registration
    public void delete(Registration registration) {
        registrationCollection.removeRegistration(registration);
    }

    // Find all registrations
    public List<Registration> findAll() {
        return registrationCollection.getRegistrations();
    }

    // Count registrations
    public int count() {
        return registrationCollection.getRegistrationCount();
    }
}
