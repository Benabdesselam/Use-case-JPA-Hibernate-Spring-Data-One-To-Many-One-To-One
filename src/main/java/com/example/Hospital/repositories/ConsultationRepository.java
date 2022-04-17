package com.example.Hospital.repositories;

import com.example.Hospital.entities.Consultation;
import com.example.Hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
