package com.example.praticien.service.dto;

import com.example.praticien.domain.Praticien;
import com.example.praticien.domain.enumeration.AddressType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PraticienUpdateDTO {

    private String lastname;
    private String firstname;
    private String phone;
    private List<AddressType> addressTypes;
    private List<String> specialityNames;

    public void updatePraticien(Praticien praticien) {
        praticien.setLastname(lastname);
        praticien.setFirstname(firstname);
        praticien.setPhone(phone);
        praticien.setAddressTypes(addressTypes);
    }
}
