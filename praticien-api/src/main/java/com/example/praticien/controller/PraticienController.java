package com.example.praticien.controller;

import com.example.praticien.common.ErrorResponseDTO;
import com.example.praticien.domain.Praticien;
import com.example.praticien.service.PraticienService;
import com.example.praticien.service.dto.PraticienDTO;
import com.example.praticien.service.dto.PraticienUpdateDTO;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("praticiens")
@Log4j2
@CrossOrigin(origins = "http://localhost:4200")
public class PraticienController {
    @Autowired
    private PraticienService praticienService;

    @PostMapping
    public ResponseEntity<?> createPraticien(@RequestBody @Valid PraticienDTO praticienDTO, Errors errors) {
        log.debug("REST request to save Bank : {}", praticienDTO);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(400, errors.getAllErrors().get(0).getDefaultMessage(), "Praticien"));
        }

        Praticien praticien = praticienService.save(praticienDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(praticien);
    }

    @GetMapping
    public ResponseEntity<?> getAllPraticiens(Pageable pageable) {
        Page<Praticien> praticienPage = praticienService.findAll(pageable);
        return ResponseEntity.ok(praticienPage);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deletePraticien(@PathVariable String email) {
        log.debug("REST request to delete Praticien : {}", email);
        boolean deleted = praticienService.delete(email);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDTO(404, "Praticien with email " +email+ " not found", "Praticien"));
        }
        return ResponseEntity.ok().body("Praticien with email " +email+ " deleted successfully");
    }


    @PutMapping("/{email}")
    public ResponseEntity<?> updatePraticien(
            @PathVariable String email,
            @Valid @RequestBody PraticienUpdateDTO praticienUpdateDTO,
            Errors errors
    ) {
        log.debug("REST request to update Praticien : {}", email);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(400, errors.getAllErrors().get(0).getDefaultMessage(), "Praticien"));
        }

        if (!praticienService.exists(email)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDTO(404, "Praticien  with id " +email+ " not found", "Praticien"));
        }

        Praticien updatedPraticien = praticienService.update(email, praticienUpdateDTO);
        return ResponseEntity.ok(updatedPraticien);

    }
}
