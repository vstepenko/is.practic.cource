package ua.edu.duan.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    @Schema(name = "id", title = "Random UUID, the id of student")
    private String id;

    @Schema(name = "name", title = "Student name")
    private String name;
}
