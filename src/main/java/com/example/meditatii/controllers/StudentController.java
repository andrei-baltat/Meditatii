package com.example.meditatii.controllers;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/student")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentCreated = studentService.saveStudent(studentDTO);
        return studentCreated;
    }

    @GetMapping("/api/student/{studentID}")
    public StudentDTO getStudent(@PathVariable("studentID") Integer studentId) {
        try {
            Optional<StudentDTO> studentById = studentService.getStudentById(studentId);
            return studentById.get();
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
    }

//    ASK: nu pot avea acelasi endpoint cu get unul sa primeasca parametrii si altul nu?

    @GetMapping("/api/students")
    public List<StudentDTO> getStudent() {
        return studentService.listAllStudents();
    }

    @GetMapping("/api/studentsDESC")
    public List<StudentDTO> getStudentsOrderByFirstNameDesc() {
        return studentService.listAllStudentsOrderByFirstNameDesc();
    }

    @GetMapping("/api/student")
    public List<StudentDTO> getStudentsByFirstName(@RequestParam(name = "firstName") final String firstName) {
        return studentService.findByFirstName(firstName);
    }

    @DeleteMapping("/api/student/{studentID}")
    public void removeStudent(@PathVariable("studentID") Integer studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/api/student")
    public StudentDTO updateStudent(@RequestBody StudentDTO student) {
        try {
            return studentService.updateStudent(student);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not updated");
        }
    }
}
