package com.example.meditatii.repositories;

import com.example.meditatii.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(final String firstName);
}
