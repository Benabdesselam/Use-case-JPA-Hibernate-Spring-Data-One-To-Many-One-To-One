package com.example.Hospital.service;

import com.example.Hospital.entities.Consultation;
import com.example.Hospital.entities.Medecin;
import com.example.Hospital.entities.Patient;
import com.example.Hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedcin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
