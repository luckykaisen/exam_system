package com.jiyinhui.exam.exception;

public class ExaminationThemeExistException extends RuntimeException {
    public ExaminationThemeExistException() {
        super();
    }

    public ExaminationThemeExistException(String message) {
        super(message);
    }

    public ExaminationThemeExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExaminationThemeExistException(Throwable cause) {
        super(cause);
    }

    protected ExaminationThemeExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
