package com.example.alternativesecurity.models.dtos;


import lombok.Data;

@Data
public class RegisterRequestDto {
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
}
