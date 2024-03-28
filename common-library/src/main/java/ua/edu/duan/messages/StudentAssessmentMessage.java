package ua.edu.duan.messages;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAssessmentMessage {

    private String idStudent;

    private String courseCode;

    private int mark;
}
