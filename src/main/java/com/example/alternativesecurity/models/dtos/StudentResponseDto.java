package com.example.alternativesecurity.models.dtos;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
}
