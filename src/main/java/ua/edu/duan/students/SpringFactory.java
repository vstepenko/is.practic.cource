package ua.edu.duan.students;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFactory {
    @Bean
    public OpenAPI openAPI(){
        OpenAPI openAPI = new OpenAPI();

        openAPI.setInfo(new Info());
        openAPI.getInfo().setTitle("Our custom title");
        openAPI.getInfo().setDescription("Big custom description");
        return openAPI;
    }

}
