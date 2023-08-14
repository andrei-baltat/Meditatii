package com.example.meditatii.services;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.exceptions.ResourceNotFoundException;
import com.example.meditatii.entities.Student;
import com.example.meditatii.mappers.StudentMapper;
import com.example.meditatii.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public List<StudentDTO> listAllStudentsOrderByFirstNameDesc() {
        return repository.findAllOrderByFirstName().stream()
                .map(mapper::studentToStudentDto)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(final Long id){
        return mapper.studentToStudentDto(repository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Student","id:", id)));
    }


    public StudentDTO saveStudent(final StudentDTO student) {
        return mapper.studentToStudentDto(repository.save(mapper.studentDtoToStudent(student)));
    }

    public StudentDTO updateStudent(final StudentDTO studentDTO) throws ResourceNotFoundException {
        Student student = repository.findById(studentDTO.getId()).orElse(null);
        if (student != null) {
            student.setFirstName(studentDTO.getFirstName());
            student.setAge(studentDTO.getAge());
            student.setLastName(studentDTO.getLastName());
            repository.save(student);
        } else {
            return StudentDTO.builder().build();
        }
        return getStudentById(studentDTO.getId());

//        repository.findById(studentDTO.getId()).ifPresent(
//                student -> {
//                    student.setFirstName(studentDTO.getFirstName());
//                    student.setAge(studentDTO.getAge());
//                    student.setLastName(studentDTO.getLastName());
//                    repository.save(student);
//                }
//        );
//
//        return getStudentById(studentDTO.getId()).orElse(StudentDTO.builder().build());
    }

    @Override
    public void deleteStudent(Integer studentId) {
        repository.deleteById(Long.valueOf(studentId));
    }

    @Override
    public List<StudentDTO> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName)
                .stream().map(mapper::studentToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(student -> mapper.studentToStudentDto(student))
//                .sorted(Comparator.comparing(StudentDTO::getId)) // deja pe findall vine sortat, sau poti face FindAllById
                .collect(Collectors.toList());
    }

//    public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
//        em.getTransaction().begin();
//
//        String jpql = "SELECT e FROM Employee e WHERE e.salary > :salary";
//        Query query = em.createQuery(jpql);
//        query.setParameter("salary", salary);
//
//        List<Employee> employees = query.getResultList();
//
//        em.getTransaction().commit(); // o grupare de mai multe operatii
//
//        return employees;
//    }
}



/**
 * entity manager este asociat cu actiuni de persistenta
 */
