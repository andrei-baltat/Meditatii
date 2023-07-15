package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDTO> listAllStudents();
}
