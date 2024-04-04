package ua.edu.duan.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ua.edu.duan.students.entity.StudentEntity;

import java.sql.Timestamp;
import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

    // @Query("FROM StudentEntity student WHERE student.course = :courseId ")
    List<StudentEntity> findByCourse(String courseId);

    @Query("FROM StudentEntity student WHERE student.registrationDateTime < :dt ")
    List<StudentEntity> findRegisteredBefore(Timestamp dt);

}
