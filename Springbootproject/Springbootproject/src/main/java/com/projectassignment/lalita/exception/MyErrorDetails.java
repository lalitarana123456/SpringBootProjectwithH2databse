package com.projectassignment.lalita.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@Data
//@NoArgsConstructor
public class MyErrorDetails {

    private final LocalDateTime timeStamp = LocalDateTime.now();
    private String message;
    private String details;

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
