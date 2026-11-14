package com.scasp.core.collections;

import com.scasp.core.AcademicRequest;
import java.util.ArrayList;
import java.util.List;

public class AcademicRequestCollection {

    private final List<AcademicRequest> requests = new ArrayList<>();

    // Add an academic request
    public synchronized void addRequest(AcademicRequest request) {
        requests.add(request);
    }

    // Remove an academic request
    public synchronized void removeRequest(AcademicRequest request) {
        requests.remove(request);
    }

    // Get all academic requests
    public synchronized List<AcademicRequest> getRequests() {
        return new ArrayList<>(requests);
    }

    // Get total number of requests
    public synchronized int getRequestCount() {
        return requests.size();
    }

    // Check if collection is empty
    public synchronized boolean isEmpty() {
        return requests.isEmpty();
    }
}