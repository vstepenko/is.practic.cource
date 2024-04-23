package ua.edu.duan.students.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.edu.duan.dto.ErrorDto;
import ua.edu.duan.dto.VallidationErrorDto;
import ua.edu.duan.students.model.exception.BussinessException;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;

@ControllerAdvice
public class StudentsControllerAdvice {

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<ErrorDto> handleBusinessException(BussinessException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setBusinessCode(e.getErrorCode().getErrorName());
        errorDto.setMessage(e.getMessage());
        errorDto.setDateTime(new Timestamp(System.currentTimeMillis()).toString());

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<VallidationErrorDto> handleValidationError(MethodArgumentNotValidException e) {
        VallidationErrorDto vallidationErrorDto = new VallidationErrorDto();

        vallidationErrorDto.setCode("validation");
        Optional.ofNullable(e.getDetailMessageArguments()).ifPresent(
                arguments-> vallidationErrorDto.setValidations(Arrays.stream(arguments)
                            .map(Object::toString)
                            .filter(it ->!StringUtils.isEmpty(it))
                            .toList())
        );

        vallidationErrorDto.setDateTime(new Timestamp(System.currentTimeMillis()).toString());
        return new ResponseEntity<>(vallidationErrorDto, HttpStatus.BAD_REQUEST);
    }
}
