
package com.scasp.core.collections;

import com.scasp.core.Registration;
import java.util.ArrayList;
import java.util.List;

public class RegistrationCollection {

    private final List<Registration> registrations = new ArrayList<>();

    // Add a registration
    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    // Remove a registration
    public void removeRegistration(Registration registration) {
        registrations.remove(registration);
    }

    // Get all registrations
    public List<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }

    // Get total number of registrations
    public int getRegistrationCount() {
        return registrations.size();
    }

    // Check if collection is empty
    public boolean isEmpty() {
        return registrations.isEmpty();
    }
}
