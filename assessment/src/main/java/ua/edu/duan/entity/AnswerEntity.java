package ua.edu.duan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(AnswerPrimaryKey.class)
@Entity
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @Column(name = "id_student")
    private String idStudent;

    @Id
    @Column(name = "id_question")
    private String idQuestion;

    @Column(name = "answer")
    private boolean answer;
}
