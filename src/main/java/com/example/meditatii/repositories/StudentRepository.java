package com.example.meditatii.repositories;

import com.example.meditatii.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(final String firstName);

    @Query(nativeQuery = true,
            value = "SELECT id, first_name, last_name, age FROM Student ORDER BY first_name DESC")
    List<Student> findAllOrderByFirstName();
}
