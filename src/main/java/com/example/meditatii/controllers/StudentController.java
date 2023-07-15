package com.example.meditatii.controllers;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/student")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO studentCreated = studentService.saveStudent(studentDTO);
        return studentCreated;
    }
}
