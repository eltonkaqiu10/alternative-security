package com.example.alternativesecurity.mappers;

import com.example.alternativesecurity.models.dtos.RegisterRequestDto;
import com.example.alternativesecurity.models.dtos.StudentResponseDto;
import com.example.alternativesecurity.models.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    private final ObjectMapper mapper;

    public StudentMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Student toEntity(RegisterRequestDto registerRequest) {
        return mapper.convertValue(registerRequest, Student.class);
    }

    public StudentResponseDto toDto(Student student) {
        return mapper.convertValue(student, StudentResponseDto.class);
    }
}
