package com.example.meditatii.controllers;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/student")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO studentCreated = studentService.saveStudent(studentDTO);
        return studentCreated;
    }

    @GetMapping("/api/student/{studentID}")
    public StudentDTO getStudent(@PathVariable("studentID") Integer studentId){
        Optional<StudentDTO> studentById = studentService.getStudentById(studentId);
        return studentById.orElseGet(() -> StudentDTO.builder().build());
    }

    @GetMapping("/api/students")
    public List<StudentDTO> getStudent(){
        return studentService.listAllStudents();
    }

    @DeleteMapping("/api/student/{studentID}")
    public void removeStudent(@PathVariable("studentID") Integer studentId){
        studentService.deleteStudent(studentId);
    }
}
