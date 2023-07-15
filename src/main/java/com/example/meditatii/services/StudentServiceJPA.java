package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.mappers.StudentMapper;
import com.example.meditatii.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceJPA implements StudentService{
    private StudentRepository repository;
    private StudentMapper mapper;

    @Override
    public List<StudentDTO> listAllStudents() {
        return repository.findAll()
                .stream()
                .map(student -> mapper.studentToStudentDTO(student))
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentById(final Long id){
        return Optional.ofNullable
                (mapper.studentToStudentDTO(repository.findById(id).orElse(null)));
    }


    public StudentDTO saveStudent(final StudentDTO student){
        return mapper.studentToStudentDTO(repository.save(mapper.studentDTOToStudent(student)));
    }

    public void updateStudent(final StudentDTO studentDTO){
        repository.findById(studentDTO.getId()).ifPresent(
                student -> {
                    student.setFirstName(studentDTO.getFirstName());
                    student.setAge(studentDTO.getAge());
                    student.setLastName(studentDTO.getLastName());
                }
        );
    }

}
