package com.temperature.exception;

public class TemperatureException extends RuntimeException {
    public TemperatureException(String temperatureNotFound) {
        super(temperatureNotFound);
    }
}
