
package com.scasp.core.collections;

import com.scasp.core.AcademicRequest;
import java.util.ArrayList;
import java.util.List;

public class AcademicRequestCollection {

    private final List<AcademicRequest> requests = new ArrayList<>();

    // Add an academic request
    public void addRequest(AcademicRequest request) {
        requests.add(request);
    }

    // Remove an academic request
    public void removeRequest(AcademicRequest request) {
        requests.remove(request);
    }

    // Get all academic requests
    public List<AcademicRequest> getRequests() {
        return new ArrayList<>(requests);
    }

    // Get total number of requests
    public int getRequestCount() {
        return requests.size();
    }

    // Check if collection is empty
    public boolean isEmpty() {
        return requests.isEmpty();
    }
}
