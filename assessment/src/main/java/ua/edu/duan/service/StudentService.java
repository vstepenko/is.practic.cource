package ua.edu.duan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.edu.duan.entity.RoleEntity;
import ua.edu.duan.entity.StudentEntity;
import ua.edu.duan.repository.StudentRepository;


@RequiredArgsConstructor
public class StudentService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        StudentEntity studentEntity = studentRepository.findByLogin(username)
                .orElseThrow(()-> new RuntimeException("Student not found"));

        return User.builder()
                .username(studentEntity.getLogin())
                .password(studentEntity.getPassword())
                .roles(studentEntity.getRoles().stream().map(RoleEntity::getCode).toArray(String[]::new))
                .disabled(!studentEntity.isEnabled())
                .build();
    }
}
