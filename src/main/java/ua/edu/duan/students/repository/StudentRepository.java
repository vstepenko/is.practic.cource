package ua.edu.duan.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.students.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {


}
