package com.jiyinhui.exam.exception;

public class CaptchaCodeException extends RuntimeException {

    public CaptchaCodeException() {
        super();
    }

    public CaptchaCodeException(String message) {
        super(message);
    }

    public CaptchaCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaCodeException(Throwable cause) {
        super(cause);
    }

    protected CaptchaCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
