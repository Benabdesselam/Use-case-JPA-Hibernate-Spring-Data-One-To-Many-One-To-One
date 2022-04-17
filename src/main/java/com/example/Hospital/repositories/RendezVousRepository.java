package com.example.Hospital.repositories;

import com.example.Hospital.entities.Patient;
import com.example.Hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
