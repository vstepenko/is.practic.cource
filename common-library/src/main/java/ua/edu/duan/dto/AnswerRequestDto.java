package ua.edu.duan.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDto {

    private String idStudent;
    private String idQuestion;
    private boolean answer;

}
