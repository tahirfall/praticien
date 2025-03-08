package com.example.praticien.controller;

import com.example.praticien.common.ErrorResponseDTO;
import com.example.praticien.domain.Speciality;
import com.example.praticien.service.SpecialityService;
import com.example.praticien.service.dto.SpecialityDTO;
import com.example.praticien.service.dto.SpecialityUpdateDTO;
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
@RequestMapping("specialities")
@Log4j2
@CrossOrigin(origins = "http://localhost:4200")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    @PostMapping
    public ResponseEntity<?> createSpeciality(@RequestBody @Valid SpecialityDTO specialityDTO, Errors errors) {
        log.debug("REST request to save Bank : {}", specialityDTO);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(400, errors.getAllErrors().get(0).getDefaultMessage(), "Speciality"));
        }

        Speciality speciality = specialityService.save(specialityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(speciality);
    }

    @GetMapping
    public ResponseEntity<?> getAllSpecialities(Pageable pageable) {
        Page<Speciality> specialityPage = specialityService.findAll(pageable);
        return ResponseEntity.ok(specialityPage);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteSpeciality(@PathVariable String name) {
        log.debug("REST request to delete Praticien : {}", name);
        boolean deleted = specialityService.delete(name);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDTO(404, "Speciality with email " +name+ " not found", "Speciality"));
        }
        return ResponseEntity.ok().body("Speciality with name " +name+ " deleted successfully");
    }


    @PutMapping("/{name}")
    public ResponseEntity<?> updateSpeciality(
            @PathVariable String name,
            @Valid @RequestBody SpecialityUpdateDTO specialityUpdateDTO,
            Errors errors
    ) {
        log.debug("REST request to update Speciality : {}", name);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(400, errors.getAllErrors().get(0).getDefaultMessage(), "Speciality"));
        }

        if (!specialityService.exists(name)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDTO(404, "Praticien  with id " +name+ " not found", "Speciality"));
        }

        Speciality updatedSpeciality = specialityService.update(name, specialityUpdateDTO);
        return ResponseEntity.ok(updatedSpeciality);

    }
}
