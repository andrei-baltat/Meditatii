package com.example.meditatii.repositories;

import com.example.meditatii.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(final String firstName);

    @Query(nativeQuery = true,
            value = "SELECT * FROM Student ORDER BY first_name DESC")
//    Query native (te folosesti de denumirile din DB) si JPQL(te folosesti de entitatile din java)
//    SELECT s FROM Student s WHERE s.age > 18
    List<Student> findAllOrderByFirstName();

}
