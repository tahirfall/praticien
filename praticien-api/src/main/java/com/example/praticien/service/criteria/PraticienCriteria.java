package com.example.praticien.service.criteria;

import lombok.Data;

import java.io.Serializable;

@Data
public class PraticienCriteria implements Serializable {

    private String lastname;
    private String firstname;
    private String email;
    private String phone;
}
