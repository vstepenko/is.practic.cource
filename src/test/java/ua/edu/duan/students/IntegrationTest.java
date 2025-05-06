package ua.edu.duan.students;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.edu.duan.dto.StudentDto;

import java.util.concurrent.FutureTask;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void addStudent() throws Exception {

        StudentDto studentDto = new StudentDto();

        studentDto.setId("some Id");
        studentDto.setCourse("IS");
        studentDto.setName("Some Name");
        studentDto.setSurname("Test");

        FutureTask<String> futureTask  = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return "Потік 2";
        });
        futureTask.state();
        mockMvc.perform(MockMvcRequestBuilders.post("/student")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(OBJECT_MAPPER.writeValueAsString(studentDto)))
                .andExpect(status().isOk());
    }
}
