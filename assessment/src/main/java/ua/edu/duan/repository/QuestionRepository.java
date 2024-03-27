package ua.edu.duan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, String> {
}
