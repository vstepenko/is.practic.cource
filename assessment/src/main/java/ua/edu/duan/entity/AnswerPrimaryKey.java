package ua.edu.duan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class AnswerPrimaryKey {
    @Id
    @Column(name = "id_student")
    private String idStudent;

    @Id
    @Column(name = "id_question")
    private String idQuestion;
}
