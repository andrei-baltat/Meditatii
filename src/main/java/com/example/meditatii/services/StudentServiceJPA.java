package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.mappers.StudentMapper;
import com.example.meditatii.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceJPA implements StudentService{
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public List<StudentDTO> listAllStudents() {
        return repository.findAll()
                .stream()
                .map(student -> mapper.studentToStudentDto(student))
                .sorted(Comparator.comparing(StudentDTO::getId))
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentById(final Integer id){
        return Optional.ofNullable
                (mapper.studentToStudentDto(repository.findById(Long.valueOf(id)).orElse(null)));
    }


    public StudentDTO saveStudent(final StudentDTO student){
        return mapper.studentToStudentDto(repository.save(mapper.studentDtoToStudent(student)));
    }

    public StudentDTO updateStudent(final StudentDTO studentDTO){
        repository.findById(Long.valueOf(studentDTO.getId())).ifPresent(
                student -> {
                    student.setFirstName(studentDTO.getFirstName());
                    student.setAge(studentDTO.getAge());
                    student.setLastName(studentDTO.getLastName());
                    repository.save(student);
                }
        );

        return getStudentById(studentDTO.getId()).orElse(StudentDTO.builder().build());
    }

    @Override
    public void deleteStudent(Integer studentId) {
        repository.deleteById(Long.valueOf(studentId));
    }

}
