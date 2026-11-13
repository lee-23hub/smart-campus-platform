package com.scasp.application.controllers;

import com.scasp.core.AcademicRequest;
import com.scasp.core.services.AcademicRequestService;
import java.util.List;

public class AcademicRequestController {

    private final AcademicRequestService requestService;

    public AcademicRequestController(AcademicRequestService requestService) {
        this.requestService = requestService;
    }

    // Add an academic request
    public void addRequest(AcademicRequest request) {
        requestService.addRequest(request);
    }

    // Retrieve all academic requests
    public List<AcademicRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    // Get total academic requests
    public int getTotalRequests() {
        return requestService.getAllRequests().size();
    }
}