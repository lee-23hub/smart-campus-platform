package com.scasp.core.interfaces;

import com.scasp.core.AcademicRequest;
import java.util.List;

public interface AcademicRequestRepositoryInterface {

    void save(AcademicRequest request);

    void delete(AcademicRequest request);

    List<AcademicRequest> findAll();

    int count();
}