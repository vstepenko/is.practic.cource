package ua.edu.duan.students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/")
public class SomeController {


    @GetMapping("/")

    public String hello(){
        return "hello";
    }
}
