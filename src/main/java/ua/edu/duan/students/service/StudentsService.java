package ua.edu.duan.students.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.duan.dto.StudentDto;
import ua.edu.duan.students.entity.StudentEntity;
import ua.edu.duan.students.repository.StudentRepository;


import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentRepository studentRepository;

    public List<StudentDto> getStudents() {
        return  studentRepository.findAll().stream().map(this::converter).toList();
    }


    public List<StudentDto> getStudentsByCourse(String course) {
        return  studentRepository.findByCourse(course).stream().map(this::converter).toList();
    }

    public List<StudentDto> getStudentsRegisteredBefore(String stringDt) {
        return  studentRepository.findRegisteredBefore(Timestamp.valueOf(stringDt)).stream().map(this::converter).toList();
    }
    @Transactional
    public void addStudent(StudentDto studentDto){

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID().toString());
        studentEntity.setName(studentDto.getName());
        studentEntity.setRegistrationDateTime(new Timestamp(System.currentTimeMillis()));
        studentEntity.setCourse(studentDto.getCourse());
        studentRepository.save(studentEntity);
    }


    @Transactional
    public void editStudent(StudentDto studentDto) {
        studentRepository.findById(studentDto.getId())
                        .ifPresent(
                                studentEntity -> {
                                    studentEntity.setName(studentDto.getName());
                                    studentEntity.setRegistrationDateTime(studentDto.getRegistrationDateTime());
                                    studentEntity.setCourse(studentDto.getCourse());
                                }
                        );
    }

    @Transactional
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public StudentDto converter(StudentEntity studentEntity){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setCourse(studentEntity.getCourse());
        studentDto.setRegistrationDateTime(studentEntity.getRegistrationDateTime());
        return studentDto;
    }

}
