package com.baeldung;

public class ManagerEntity {

    private Long id;

    private String firstName;

    private String lastName;

    public ManagerEntity(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ManagerEntity() {
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
}
