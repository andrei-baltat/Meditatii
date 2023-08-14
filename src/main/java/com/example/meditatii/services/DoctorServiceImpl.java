package com.example.meditatii.services;

import com.example.meditatii.DTO.DoctorDTO;
import com.example.meditatii.mappers.DoctorMapper;
import com.example.meditatii.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private DoctorRepository doctorRepository;
    private DoctorMapper mapper;

    @Override
    public List<DoctorDTO> listAll() {
        return doctorRepository.findAll().stream()
                .map(doctor -> mapper.doctorToDoctorDto(doctor))
                .toList();
    }

    @Override
    public List<DoctorDTO> listAllWithPaging(Integer page, Integer size){
        return doctorRepository.findAll(PageRequest.of(page, size)).stream()
                .map(doctor -> mapper.doctorToDoctorDto(doctor))
                .toList();
    }

    @Override
    public DoctorDTO save(DoctorDTO doctor) {
        return mapper.doctorToDoctorDto(doctorRepository.save(mapper.doctorDtoToDoctor(doctor)));

//        return mapper.doctorToDoctorDto(
//                doctorRepository.findById(savedDoctor.getId())
//                        .orElse(Doctor.builder().build()));
    }
}
