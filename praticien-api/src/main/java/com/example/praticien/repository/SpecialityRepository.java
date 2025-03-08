package com.example.praticien.repository;

import com.example.praticien.domain.Speciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends MongoRepository<Speciality, String> {

    boolean existsByName(String name);

    Speciality findByName(String name);

    List<Speciality> findByNameIn(List<String> names);
}
