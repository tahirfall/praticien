package com.example.praticien.service.dto;

import com.example.praticien.domain.Praticien;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PraticienDTO {


    private String lastname;
    private String firstname;
    @NotNull(message = "'email' cannot be null")
    @NotBlank(message = "'email' cannot be blank")
    private String email;
    private String phone;

    private List<String> specialityNames;

    public Praticien generatePraticien() {
        Praticien praticien = new Praticien();
        praticien.setLastname(lastname);
        praticien.setFirstname(firstname);
        praticien.setEmail(email);
        praticien.setPhone(phone);

        return praticien;
    }
}
