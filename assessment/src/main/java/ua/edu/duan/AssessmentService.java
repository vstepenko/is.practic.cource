package ua.edu.duan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ua.edu.duan.dto.AnswerRequestDto;
import ua.edu.duan.dto.DoneRequestDto;
import ua.edu.duan.entity.AnswerEntity;
import ua.edu.duan.entity.AnswerPrimaryKey;
import ua.edu.duan.entity.QuestionEntity;
import ua.edu.duan.messages.StudentAssessmentMessage;
import ua.edu.duan.repository.AnswerRepository;
import ua.edu.duan.repository.QuestionRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssessmentService {

    private final RabbitTemplate rabbitTemplate;

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    private final EntityManager entityManager;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public void done(DoneRequestDto doneRequestDto){


        StudentAssessmentMessage message = new StudentAssessmentMessage();
        message.setIdStudent(doneRequestDto.getIdStudent());
        message.setCourseCode(doneRequestDto.getCourseCode());
        message.setMark(calculateMark(doneRequestDto.getIdStudent(),doneRequestDto.getCourseCode()));

        try {
            rabbitTemplate.convertAndSend("student", OBJECT_MAPPER.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private int calculateMark(String studentId, String courseCode){
        return 0;
    }

    public String getQuestion(String idQuestion) {

        return questionRepository.findById(idQuestion).map(QuestionEntity::getDescription).orElse(null);
    }

    @Transactional
    public void answerQuestion(AnswerRequestDto answerRequestDto) {
        log.info("Save answer to DB");
        AnswerEntity answerEntity = answerRepository
                .findById(new AnswerPrimaryKey(answerRequestDto.getIdStudent(), answerRequestDto.getIdQuestion()))
                .orElseGet(AnswerEntity::new);
        answerEntity.setIdQuestion(answerRequestDto.getIdQuestion());
        answerEntity.setIdStudent(answerRequestDto.getIdStudent());
        answerEntity.setAnswer(answerRequestDto.isAnswer());
        entityManager.persist(answerEntity);

    }


}
