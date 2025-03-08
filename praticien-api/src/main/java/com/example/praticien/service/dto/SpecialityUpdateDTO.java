package com.example.praticien.service.dto;

import com.example.praticien.domain.Speciality;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SpecialityUpdateDTO {

    @NotNull(message = "'name' cannot be null")
    @NotBlank(message = "'name' cannot be blank")
    private String name;
    private String description;

    public void updateSpeciality(Speciality speciality) {
        speciality.setName(name);
        speciality.setDescription(description);
    }
}
