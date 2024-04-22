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
@Table(name="role")
public class RoleEntity {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;
}
