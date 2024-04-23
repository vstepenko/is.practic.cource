package ua.edu.duan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VallidationErrorDto {
    private String code;
    private List<String> validations;
    private String dateTime;
}
