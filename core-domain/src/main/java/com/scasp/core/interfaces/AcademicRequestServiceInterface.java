package com.scasp.core.interfaces;

import com.scasp.core.AcademicRequest;
import java.util.List;

public interface AcademicRequestServiceInterface {

    void addRequest(AcademicRequest request);

    void removeRequest(AcademicRequest request);

    List<AcademicRequest> getAllRequests();

    int getTotalRequests();
}