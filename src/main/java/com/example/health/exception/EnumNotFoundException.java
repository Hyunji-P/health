package com.example.health.exception;

import java.io.Serial;

/**
 * Enum 데이터가 없을 때 발생하는 커스텀 Exception
 */
public class EnumNotFoundException extends NotFoundException{

    @Serial
    private static final long serialVersionUID = -6070963008594268460L;

    public EnumNotFoundException() {
        super();
    }

    public EnumNotFoundException(String message) {
        super(message);
    }

    public EnumNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnumNotFoundException(Throwable cause) {
        super(cause);
    }
}
