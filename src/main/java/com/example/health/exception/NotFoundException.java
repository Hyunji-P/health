package com.example.health.exception;

import java.io.Serial;

/**
 * 데이터를 찾을 수 없을 수 없을 때 발생하는 커스텀 Exception
 */
public abstract class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
