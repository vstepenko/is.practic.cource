package ua.edu.duan.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class StudentDto {


    @Schema(name = "id", title = "Random UUID, the id of student")
    private String id;

    @Size(min =4, max =10)
    @Schema(name = "name", title = "Student name")
    private String name;

    private Timestamp registrationDateTime;

    @NotBlank
    private String course;

    @Size(min =4, max =10)
    private String surname;
}
