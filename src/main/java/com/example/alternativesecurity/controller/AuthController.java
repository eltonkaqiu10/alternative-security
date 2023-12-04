package com.example.alternativesecurity.controller;

import com.example.alternativesecurity.mappers.StudentMapper;
import com.example.alternativesecurity.models.dtos.LoginRequestDto;
import com.example.alternativesecurity.models.dtos.RegisterRequestDto;
import com.example.alternativesecurity.models.dtos.StudentResponseDto;
import com.example.alternativesecurity.services.AuthService;
import com.example.alternativesecurity.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final StudentMapper mapper;
    private final StudentService service;
    private final AuthService authService;

    public AuthController(StudentMapper mapper, StudentService service, AuthService authService) {
        this.mapper = mapper;
        this.service = service;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest) {
        authService.loginRequest(loginRequest.getUserName());
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/register")
    public ResponseEntity<StudentResponseDto> register(@RequestBody RegisterRequestDto registerRequest) {
        return ResponseEntity.ok(mapper
                .toDto(service.registerStudent(
                        mapper.toEntity(registerRequest))));
    }
}
