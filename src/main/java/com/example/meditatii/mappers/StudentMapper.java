package com.example.meditatii.mappers;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.entities.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    StudentDTO studentToStudentDTO(final Student student);
    Student studentDTOToStudent(final StudentDTO studentDTO);
}
