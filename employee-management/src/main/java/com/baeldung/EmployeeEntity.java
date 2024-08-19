package com.baeldung;

public class EmployeeEntity {

    private Long id;

    private String firstName;

    private String lastName;

    private boolean isManager;

    public EmployeeEntity(Long id, String firstName, String lastName, boolean isManager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isManager = isManager;
    }

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isManager() {
        return isManager;
    }
}
