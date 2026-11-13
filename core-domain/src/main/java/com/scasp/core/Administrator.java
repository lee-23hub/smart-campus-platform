
package com.scasp.core;

public class Administrator {

    private String administratorId;
    private String fullName;
    private String email;

    public Administrator(String administratorId,
                         String fullName, String email) {
        this.administratorId = administratorId;
        this.fullName = fullName;
        this.email = email;
    }

    public String getAdministratorId() {
        return administratorId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
