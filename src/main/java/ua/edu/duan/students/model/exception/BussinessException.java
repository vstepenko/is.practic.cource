package ua.edu.duan.students.model.exception;

import lombok.Getter;

public class BussinessException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;
    public BussinessException( ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
