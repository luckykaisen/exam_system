package com.jiyinhui.exam.exception;

public class CreateExaminationPaperException extends RuntimeException {

    public CreateExaminationPaperException() {
        super();
    }

    public CreateExaminationPaperException(String message) {
        super(message);
    }

    public CreateExaminationPaperException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateExaminationPaperException(Throwable cause) {
        super(cause);
    }

    protected CreateExaminationPaperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
