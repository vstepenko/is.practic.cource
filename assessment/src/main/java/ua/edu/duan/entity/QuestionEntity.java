package ua.edu.duan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "desctiption")
    private String description;

    @Column(name = "answer")
    private boolean answer;

    @Column(name = "couse_code")
    private String cousreCode;
}
