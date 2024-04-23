package ua.edu.duan.students.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.dto.StudentDto;
import ua.edu.duan.students.service.StudentsService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@Tag(name = "student controller", description = "CRUD operations on student DB")
@RequestMapping("/student")
public class StudentsController {


    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping()
    @Operation(summary ="get students", description = "return all students from DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<StudentDto> getStudents(){
        return studentsService.getStudents();
    }

    @GetMapping("/bycourse")
    public List<StudentDto> getStudentsByCourse(@RequestParam String course){
        return studentsService.getStudentsByCourse(course);
    }

    @GetMapping("/before")
    public List<StudentDto> getStudentsBefore(@RequestParam String dt){
        return studentsService.getStudentsRegisteredBefore(dt);
    }

    @PostMapping()
    @Operation(summary ="Add students", description = "Add student to DB")
    public void addStudent(@RequestBody @Valid StudentDto studentDto){
        studentsService.addStudent(studentDto);
    }

    @PutMapping()
    @Operation(summary ="Edit student", description = "Add student to DB")
    public void editStudent(@RequestBody StudentDto studentDto){
        studentsService.editStudent(studentDto);
    }

    @DeleteMapping()
    @Operation(summary ="Delete Student", description = "Add student to DB")
    public void deleteStudent(@RequestParam String id){
        studentsService.deleteStudent(id);
    }
}
