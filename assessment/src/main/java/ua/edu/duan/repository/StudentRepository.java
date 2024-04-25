package ua.edu.duan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.entity.StudentEntity;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

    Optional<StudentEntity> findByLogin(String login);
}
