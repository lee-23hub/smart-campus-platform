package com.scasp.core.enterprise;

import com.scasp.core.AcademicRequest;
import com.scasp.core.interfaces.AcademicRequestServiceInterface;
import java.util.List;

public class AcademicRequestEnterpriseService {

    private final AcademicRequestServiceInterface requestService;

    public AcademicRequestEnterpriseService(
            AcademicRequestServiceInterface requestService) {
        this.requestService = requestService;
    }

    public void addRequest(AcademicRequest request) {
        requestService.addRequest(request);
    }

    public List<AcademicRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    public int getTotalRequests() {
        return requestService.getTotalRequests();
    }
}