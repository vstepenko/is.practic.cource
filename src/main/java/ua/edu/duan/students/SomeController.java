package ua.edu.duan.students;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.students.service.SomeService;


@RestController("/")
@RequiredArgsConstructor
public class SomeController {

    private final SomeService someService;
    @GetMapping("/")
    public String hello() {
        return someService.hello();
    }
}
