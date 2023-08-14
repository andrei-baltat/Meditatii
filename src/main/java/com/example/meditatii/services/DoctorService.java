package com.example.meditatii.services;

import com.example.meditatii.DTO.DoctorDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DoctorService{
    List<DoctorDTO> listAll();

    List<DoctorDTO> listAllWithPaging(Integer page, Integer size);

    DoctorDTO save(DoctorDTO doctor);
}
