package com.example.praticien.domain;

import com.example.praticien.domain.enumeration.AddressType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "praticiens")
public class Praticien implements Serializable {

    @Id
    private String email;
    private String lastname;
    private String firstname;
    private String phone;

    @DBRef
    private List<Speciality> specialities;

    private List<AddressType> addressTypes;

}
