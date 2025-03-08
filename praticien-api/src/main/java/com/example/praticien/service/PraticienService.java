package com.example.praticien.service;

import com.example.praticien.domain.Praticien;
import com.example.praticien.domain.Speciality;
import com.example.praticien.repository.PraticienRepository;
import com.example.praticien.repository.SpecialityRepository;
import com.example.praticien.service.dto.PraticienDTO;
import com.example.praticien.service.dto.PraticienUpdateDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Log4j2
public class PraticienService {

    @Autowired
    private PraticienRepository praticienRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Transactional
    public Praticien save(PraticienDTO praticienDTO) {
        log.debug("Request to save Praticien : {}", praticienDTO);

        Praticien praticien = praticienDTO.generatePraticien();

        List<Speciality> specialities = specialityRepository.findByNameIn(praticienDTO.getSpecialityNames());

        praticien.setSpecialities(specialities);

        return this.praticienRepository.save(praticien);
    }


    @Transactional(readOnly = true)
    public Page<Praticien> findAll(Pageable pageable) {
        return this.praticienRepository.findAll(pageable);
    }

    @Transactional
    public boolean delete(String email) {
        log.debug("Request to delete Praticien : {}", email);
        Praticien praticien = this.praticienRepository.findByEmail(email);
        if (praticien != null) {
            this.praticienRepository.delete(praticien);
            return true;
        }
        return false;
    }

    @Transactional
    public Praticien update(String email, PraticienUpdateDTO praticienUpdateDTO) {
        log.debug("Request to update Praticien : {}", email);
        Praticien praticien = this.praticienRepository.findByEmail(email);
        if (praticien == null) {
            return null;
        }

        praticienUpdateDTO.updatePraticien(praticien);
        if(praticien.getSpecialities() != null && !praticien.getSpecialities().isEmpty()) {
            List<Speciality> specialities = specialityRepository.findByNameIn(praticienUpdateDTO.getSpecialityNames());
            praticien.setSpecialities(specialities);
        }

        return this.praticienRepository.save(praticien);
    }

    @Transactional(readOnly = true)
    public boolean exists(String email) {
        return this.praticienRepository.existsByEmail(email);
    }

}
