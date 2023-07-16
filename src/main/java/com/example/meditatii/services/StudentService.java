package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> listAllStudents();
    StudentDTO saveStudent(final StudentDTO studentDTO);
    Optional<StudentDTO> getStudentById(final Integer id);
    StudentDTO updateStudent(final StudentDTO studentDTO);
    void deleteStudent(final Integer studentId);
}
