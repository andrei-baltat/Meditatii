package com.example.meditatii.controllers;

import com.example.meditatii.DTO.DoctorDTO;
import com.example.meditatii.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@AllArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @GetMapping("api/doctors")
    public ResponseEntity<List<DoctorDTO>> getDoctors(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        List<DoctorDTO> allDoctors = service.listAllWithPaging(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(allDoctors);
    }

    @PostMapping("api/doctors")
    public ResponseEntity<DoctorDTO> saveDoctor(@RequestBody DoctorDTO doctor){
        DoctorDTO doctorDTO = service.save(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDTO);
    }

//    si aici e ok sa faci handler de exceptii

}

