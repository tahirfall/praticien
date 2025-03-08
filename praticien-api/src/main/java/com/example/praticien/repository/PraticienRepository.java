package com.example.praticien.repository;

import com.example.praticien.domain.Praticien;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PraticienRepository extends MongoRepository<Praticien, String> {

    boolean existsByEmail(String email);

    Praticien findByEmail(String email);
}
