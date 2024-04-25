package ua.edu.duan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.edu.duan.repository.StudentRepository;
import ua.edu.duan.service.StudentService;

@Configuration
public class SpringFactory {


    @Bean
    public StudentService studentService(StudentRepository studentRepository){
        return new StudentService(studentRepository);

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(StudentService studentService,  BCryptPasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(studentService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder); //set the password encoder - bcrypt
        return auth;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> {
                    configurer.requestMatchers(HttpMethod.GET, "/swagger-ui/**").hasRole("STUDENT");
                    configurer.requestMatchers(HttpMethod.GET, "/v3/api-docs/**").hasRole("STUDENT");
                    configurer.requestMatchers(HttpMethod.GET, "/v3/api-docs").hasRole("STUDENT");
                }

        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
