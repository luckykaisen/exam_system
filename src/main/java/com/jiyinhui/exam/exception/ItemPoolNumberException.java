package com.jiyinhui.exam.exception;

public class ItemPoolNumberException extends RuntimeException {
    public ItemPoolNumberException() {
        super();
    }

    public ItemPoolNumberException(String message) {
        super(message);
    }

    public ItemPoolNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemPoolNumberException(Throwable cause) {
        super(cause);
    }

    protected ItemPoolNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
