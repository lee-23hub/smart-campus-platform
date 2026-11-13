
package com.scasp.core;

import java.time.LocalDate;

public class AcademicRequest {

    private String requestId;
    private Student student;
    private String requestType;
    private String description;
    private LocalDate submissionDate;
    private String status;

    public AcademicRequest(String requestId, Student student,
                           String requestType, String description,
                           LocalDate submissionDate, String status) {
        this.requestId = requestId;
        this.student = student;
        this.requestType = requestType;
        this.description = description;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public Student getStudent() {
        return student;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
