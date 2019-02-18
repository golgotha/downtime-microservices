package com.comncon.downtime.scheduler.repository;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
