package com.location.exception;

public class LocationServiceException extends RuntimeException{
    public LocationServiceException(String message) {
        super(message);
    }
}
