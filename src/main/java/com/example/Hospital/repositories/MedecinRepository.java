package com.example.Hospital.repositories;

import com.example.Hospital.entities.Medecin;
import com.example.Hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
