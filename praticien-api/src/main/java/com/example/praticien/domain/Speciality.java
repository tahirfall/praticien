package com.example.praticien.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "specialities")
public class Speciality implements Serializable {

    @Id
    private String name;
    private String description;
}
