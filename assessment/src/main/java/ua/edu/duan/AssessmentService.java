package ua.edu.duan;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ua.edu.duan.entity.QuestionEntity;
import ua.edu.duan.repository.QuestionRepository;

@Service
@RequiredArgsConstructor
public class AssessmentService {

    private final RabbitTemplate rabbitTemplate;

    private final QuestionRepository questionRepository;
    public void done(){
        rabbitTemplate.convertAndSend("student","Hello from assessment service");
    }

    public String getQuestion(String idQuestion) {

        return questionRepository.findById(idQuestion).map(QuestionEntity::getDescription).orElse(null);
    }
}
