package com.example.praticien.service.dto;

import com.example.praticien.domain.Speciality;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SpecialityDTO {

    @NotNull(message = "'name' cannot be null")
    @NotBlank(message = "'name' cannot be blank")
    private String name;
    private String description;

    public Speciality generateSpeciality() {
        Speciality speciality = new Speciality();
        speciality.setName(name);
        speciality.setDescription(description);

        return speciality;
    }
}
