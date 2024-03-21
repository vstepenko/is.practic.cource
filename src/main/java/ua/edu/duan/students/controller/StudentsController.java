package ua.edu.duan.students.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.students.dto.StudentDto;
import ua.edu.duan.students.service.StudentsService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsController {


    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping()
    public List<StudentDto> getStudents(){
        return studentsService.getStudents();
    }

    @PostMapping()
    public void addStudent(@RequestBody StudentDto studentDto){
        studentsService.addStudent(studentDto);
    }
}
