package com.example.praticien.service;

import com.example.praticien.domain.Speciality;
import com.example.praticien.repository.SpecialityRepository;
import com.example.praticien.service.dto.SpecialityDTO;
import com.example.praticien.service.dto.SpecialityUpdateDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Transactional
    public Speciality save(SpecialityDTO specialityDTO) {
        log.debug("Request to save Speciality : {}", specialityDTO);

        Speciality speciality = specialityDTO.generateSpeciality();
        return this.specialityRepository.save(speciality);
    }


    @Transactional(readOnly = true)
    public Page<Speciality> findAll(Pageable pageable) {
        return this.specialityRepository.findAll(pageable);
    }

    @Transactional
    public boolean delete(String name) {
        log.debug("Request to delete Praticien : {}", name);
        Speciality speciality = this.specialityRepository.findByName(name);
        if (speciality != null) {
            this.specialityRepository.delete(speciality);
            return true;
        }
        return false;
    }

    @Transactional
    public Speciality update(String name, SpecialityUpdateDTO specialityUpdateDTO) {
        log.debug("Request to update Speciality : {}", name);
        Speciality speciality = this.specialityRepository.findByName(name);
        if (speciality == null) {
            return null;
        }

        specialityUpdateDTO.updateSpeciality(speciality);

        return this.specialityRepository.save(speciality);
    }

    @Transactional(readOnly = true)
    public boolean exists(String name) {
        return this.specialityRepository.existsByName(name);
    }

}
