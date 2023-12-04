package com.example.alternativesecurity.services;

import com.example.alternativesecurity.models.entities.Student;
import com.example.alternativesecurity.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student getStudentByUserNameOrEmail(String userName, String email) {
        return repository.findByUserNameOrEmail(userName, email).orElse(null);
    }

    public Student getStudentByUserName(String userName) {
        return repository.findByUserName(userName).orElse(null);
    }

    public Student registerStudent(Student student) {
        Student existingStudent = getStudentByUserNameOrEmail(student.getUserName(), student.getEmail());
        if (existingStudent == null)
            return repository.save(student);
        return existingStudent;
    }
}
