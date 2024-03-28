package ua.edu.duan;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.dto.AnswerRequestDto;
import ua.edu.duan.dto.DoneRequestDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assessment")
public class AssessmentController {

    private final AssessmentService assessmentService;
    @PostMapping("/done")
    public void done(@RequestBody DoneRequestDto doneRequestDto) {
        assessmentService.done(doneRequestDto);
    }

    @GetMapping("/question")
    public String getQuestion(@RequestParam String idQuestion) {
       return assessmentService.getQuestion(idQuestion);
    }

    @PostMapping("/answer")
    public void answerQuestion(@RequestBody AnswerRequestDto answerRequestDto){
        assessmentService.answerQuestion(answerRequestDto);
    }
}
