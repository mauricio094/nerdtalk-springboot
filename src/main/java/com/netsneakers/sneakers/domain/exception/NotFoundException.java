package com.netsneakers.sneakers.domain.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NotFoundException extends SneakerException {

    private Object[] msgParams;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message, Object... msgParams) {
        super(message, msgParams);
    }

    public NotFoundException(String message, Throwable cause, Object[] msgParams) {
        super(message, cause, msgParams);
    }
}
