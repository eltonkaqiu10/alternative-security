package com.example.alternativesecurity.repositories;

import com.example.alternativesecurity.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByUserName(String userName);

    Optional<Student> findByUserNameOrEmail(String userName, String email);
}
