package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.controllers.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> listAllStudents();

    List<StudentDTO> listAllStudentsOrderByFirstNameDesc();

    StudentDTO saveStudent(final StudentDTO studentDTO);

    Optional<StudentDTO> getStudentById(final Integer id) throws StudentNotFoundException;

    StudentDTO updateStudent(final StudentDTO studentDTO) throws StudentNotFoundException;

    void deleteStudent(final Integer studentId);

    List<StudentDTO> findByFirstName(final String firstName);
}
