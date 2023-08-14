package com.example.meditatii.mappers;

import com.example.meditatii.DTO.DoctorDTO;
import com.example.meditatii.entities.Doctor;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper {

    Doctor doctorDtoToDoctor(final DoctorDTO doctorDTO);
    DoctorDTO doctorToDoctorDto(final Doctor doctor);
}
