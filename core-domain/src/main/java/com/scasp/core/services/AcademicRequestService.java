
package com.scasp.core.services;

import com.scasp.core.AcademicRequest;
import com.scasp.core.collections.AcademicRequestCollection;
import java.util.List;

public class AcademicRequestService {

    private final AcademicRequestCollection requestCollection;

    public AcademicRequestService(AcademicRequestCollection requestCollection) {
        this.requestCollection = requestCollection;
    }

    // Add an academic request
    public void addRequest(AcademicRequest request) {
        requestCollection.addRequest(request);
    }

    // Remove an academic request
    public void removeRequest(AcademicRequest request) {
        requestCollection.removeRequest(request);
    }

    // Retrieve all academic requests
    public List<AcademicRequest> getAllRequests() {
        return requestCollection.getRequests();
    }

    // Get total academic requests
    public int getTotalRequests() {
        return requestCollection.getRequestCount();
    }
}
