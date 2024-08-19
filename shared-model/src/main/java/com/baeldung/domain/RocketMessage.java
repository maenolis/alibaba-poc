package com.baeldung.domain;

public class RocketMessage {

    private Long id;

    private String message;

    public RocketMessage() {
    }

    public RocketMessage(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RocketMessage{" + "id=" + id + ", message='" + message + '\'' + '}';
    }
}
