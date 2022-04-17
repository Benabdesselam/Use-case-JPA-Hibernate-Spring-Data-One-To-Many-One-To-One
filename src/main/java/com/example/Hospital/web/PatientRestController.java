package com.example.Hospital.web;

import com.example.Hospital.entities.Patient;
import com.example.Hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<Patient> patientList()
    {
    return patientRepository.findAll();
    }
}
