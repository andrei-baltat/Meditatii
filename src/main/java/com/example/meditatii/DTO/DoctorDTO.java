package com.example.meditatii.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
}
