package com.example.praticien.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private int code;
    private String message;
    private String entity;
}
