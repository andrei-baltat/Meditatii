package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService{

    List<StudentDTO> listAllStudentsOrderByFirstNameDesc();

    StudentDTO saveStudent(final StudentDTO studentDTO);

    StudentDTO getStudentById(final Long id);

    StudentDTO updateStudent(final StudentDTO studentDTO);

    void deleteStudent(final Integer studentId);

    List<StudentDTO> findByFirstName(final String firstName);

    List<StudentDTO> listAll();
}
