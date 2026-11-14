package com.scasp.core.interfaces;

import com.scasp.core.Registration;
import java.util.List;

public interface RegistrationServiceInterface {

    void addRegistration(Registration registration);

    void removeRegistration(Registration registration);

    List<Registration> getAllRegistrations();

    int getTotalRegistrations();
}