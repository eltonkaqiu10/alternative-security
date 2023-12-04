package com.example.alternativesecurity.services;

import com.example.alternativesecurity.models.entities.AuthCode;
import com.example.alternativesecurity.models.entities.Student;
import com.example.alternativesecurity.repositories.AuthCodeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {
    private final StudentService service;
    private final AuthCodeRepository repository;

    public AuthService(StudentService service, AuthCodeRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public boolean loginRequest(String userNameOrEmail) {
        Student student = service.getStudentByUserNameOrEmail(userNameOrEmail, userNameOrEmail);
        if (student != null) {
            Optional<AuthCode> existingAuthCode = repository.findByStudent(student);
            if (existingAuthCode.isPresent()) {
                Random random = new Random();
                AuthCode loginCode = new AuthCode();
                loginCode.setCode(random.nextInt(1000, 9999));
                loginCode.setStudent(student);
                repository.save(loginCode);
                return true;
            }
        }
        return false;
    }


}
