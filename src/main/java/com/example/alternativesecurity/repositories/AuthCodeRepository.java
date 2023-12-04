package com.example.alternativesecurity.repositories;

import com.example.alternativesecurity.models.entities.AuthCode;
import com.example.alternativesecurity.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthCodeRepository extends JpaRepository<AuthCode, Integer> {
    Optional<AuthCode> findByStudent(Student student);
}
