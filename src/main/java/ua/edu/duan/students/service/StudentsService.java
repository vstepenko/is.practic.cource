package ua.edu.duan.students.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.duan.dto.StudentDto;
import ua.edu.duan.students.entity.StudentEntity;
import ua.edu.duan.students.repository.StudentRepository;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentRepository studentRepository;
    private final EntityManager entityManager;

    public List<StudentDto> getStudents() {
        return  studentRepository.findAll().stream().map(this::converter).toList();
    }

    @Transactional
    public void addStudent(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID().toString());
        studentEntity.setName(studentDto.getName());
        entityManager.persist(studentEntity);
    }

    public StudentDto converter(StudentEntity studentEntity){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        return studentDto;
    }

}
