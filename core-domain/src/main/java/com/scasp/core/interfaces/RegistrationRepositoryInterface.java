package com.scasp.core.interfaces;

import com.scasp.core.Registration;
import java.util.List;

public interface RegistrationRepositoryInterface {

    void save(Registration registration);

    void delete(Registration registration);

    List<Registration> findAll();

    int count();
}