package ua.edu.duan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.entity.AnswerEntity;
import ua.edu.duan.entity.AnswerPrimaryKey;

public interface AnswerRepository extends JpaRepository<AnswerEntity, AnswerPrimaryKey> {
}
