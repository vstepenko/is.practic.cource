package ua.edu.duan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {

    private String businessCode;

    private String message;

    private String dateTime;
}
