package ua.edu.duan;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.duan.dto.StudentDto;

import java.util.List;

@FeignClient( name =  "student", url = "http://localhost:8081")
public interface StudentFeignClient {

    @GetMapping("/student")
    List<StudentDto> getStudents();

}
