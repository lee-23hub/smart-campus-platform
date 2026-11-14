
package com.scasp.core.repositories;

import com.scasp.core.interfaces.AcademicRequestRepositoryInterface;
import com.scasp.core.AcademicRequest;
import com.scasp.core.collections.AcademicRequestCollection;
import java.util.List;

public class AcademicRequestRepository implements AcademicRequestRepositoryInterface {

    private final AcademicRequestCollection requestCollection;

    public AcademicRequestRepository(AcademicRequestCollection requestCollection) {
        this.requestCollection = requestCollection;
    }

    // Save an academic request
    public void save(AcademicRequest request) {
        requestCollection.addRequest(request);
    }

    // Delete an academic request
    public void delete(AcademicRequest request) {
        requestCollection.removeRequest(request);
    }

    // Find all academic requests
    public List<AcademicRequest> findAll() {
        return requestCollection.getRequests();
    }

    // Count academic requests
    public int count() {
        return requestCollection.getRequestCount();
    }
}
