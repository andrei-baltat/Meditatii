package com.example.meditatii.mappers;

import com.example.meditatii.DTO.StudentDTO;
import com.example.meditatii.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student studentDtoToStudent(final StudentDTO studentDTO);

    StudentDTO studentToStudentDto(final Student student);
}
