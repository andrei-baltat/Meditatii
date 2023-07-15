package com.example.meditatii.mappers;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.entities.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    StudentDTO studentToStudentDto(final Student student);
    Student studentDtoToStudent(final StudentDTO studentDTO);
}
