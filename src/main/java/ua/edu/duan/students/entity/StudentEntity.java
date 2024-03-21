package ua.edu.duan.students.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

}
