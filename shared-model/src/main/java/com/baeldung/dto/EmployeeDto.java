package com.baeldung.dto;

public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private boolean isManager;

    public EmployeeDto(Long id, String firstName, String lastName, boolean isManager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isManager = isManager;
    }

    public EmployeeDto() {
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
