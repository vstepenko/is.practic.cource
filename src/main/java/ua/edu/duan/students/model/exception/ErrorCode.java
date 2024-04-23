package ua.edu.duan.students.model.exception;

import lombok.Getter;

public enum ErrorCode {
    COURSE_NOT_FOUND("CourseNotFound"),
    STUDENT_NOT_FOUND("StudentNotFound"),

    ;

    @Getter
    private String errorName;

     ErrorCode(String name){
        this.errorName = name;
    }
}