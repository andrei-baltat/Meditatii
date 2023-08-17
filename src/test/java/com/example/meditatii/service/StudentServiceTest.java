package com.example.meditatii.service;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.entities.Student;
import com.example.meditatii.repositories.StudentRepository;
import com.example.meditatii.services.StudentService;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

@SpringBootTest()
public class StudentServiceTest {
//    mock = un obiect simulat
    @Mock
    StudentRepository repository;

    @InjectMocks
    StudentService service;

    @Test
    @Transactional // daca pica se face rollback
    @Rollback // dupa ce se termina se face roll back
    public void testFindById(){
        Long id = 10L;
        Student student = Student.builder().age(10).lastName("Andrei").firstName("A").id(id).build();
        Mockito.doReturn(student).when(repository.findById(id));
        StudentDTO studentById = service.getStudentById(id);

        verify(repository).findById(id);     // verifici ca s-a facut callul
        assertNotNull(studentById);         // verifici ca nu e diferit de null
        assertEquals(id, studentById.getId());// verifici ca s-a intors ce trebuie
    }
    /**
     * @Test
     *     public void testFindStudentById_ExistingStudent() {
     *         StudentService studentService = new StudentService(studentRepository);
     *
     *         // Creați un student pentru test
     *         Long studentId = 1L;
     *         Student expectedStudent = new Student("John", "Doe", "john@example.com");
     *         when(studentRepository.findStudentById(studentId)).thenReturn(Optional.of(expectedStudent));
     *
     *         // Apelul metodei findStudentById
     *         Student foundStudent = studentService.findStudentById(studentId);
     *
     *         // Verificați că repository-ul a fost apelat cu ID-ul corect
     *         verify(studentRepository).findStudentById(studentId);
     *
     *         // Verificați că studentul returnat este cel așteptat
     *         assertEquals(expectedStudent, foundStudent);
     *     }
     */
}
