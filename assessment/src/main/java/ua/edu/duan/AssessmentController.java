package ua.edu.duan;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assessment")
public class AssessmentController {

    private final AssessmentService assessmentService;
    @PostMapping("/done")
    public void done() {
        assessmentService.done();
    }

    @GetMapping("/question")
    public String getQuestion(@RequestParam String idQuestion) {
       return assessmentService.getQuestion(idQuestion);
    }
}
