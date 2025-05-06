package ua.edu.duan.students.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.edu.duan.dto.StudentDto;
import ua.edu.duan.students.entity.StudentEntity;
import ua.edu.duan.students.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentsServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentsService studentsService;

    @Test
    public void addStudentTest(){
        StudentDto studentDto = new StudentDto();

        studentDto.setId("some Id");
        studentDto.setCourse("IS");
        studentDto.setName("Some Name");
        studentDto.setSurname("Test Surname");

        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(new StudentEntity());
        studentsService.addStudent(studentDto);
        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any());
    }
}
