package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> listAllStudents();
    StudentDTO saveStudent(StudentDTO studentDTO);
    Optional<StudentDTO> getStudentById(final Long id);
    void updateStudent(final StudentDTO studentDTO);
}
