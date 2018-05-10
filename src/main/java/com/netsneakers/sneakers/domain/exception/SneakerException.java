package com.netsneakers.sneakers.domain.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SneakerException extends Exception {

    private Object[] msgParams;

    public SneakerException(String message) {
        super(message);
    }

    public SneakerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SneakerException(String message, Object... msgParams) {
        super(message);
        this.msgParams = msgParams;
    }

    public SneakerException(String message, Throwable cause, Object[] msgParams) {
        super(message, cause);
        this.msgParams = msgParams;
    }
}


