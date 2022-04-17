package com.example.Hospital;

import com.example.Hospital.entities.*;
import com.example.Hospital.repositories.ConsultationRepository;
import com.example.Hospital.repositories.MedecinRepository;
import com.example.Hospital.repositories.PatientRepository;
import com.example.Hospital.repositories.RendezVousRepository;
import com.example.Hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.naming.Name;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							RendezVousRepository rendezVousRepository ,
			                MedecinRepository medecinRepository)
	{
      return args -> {
		  Stream.of("aymen","ismail","reda")
				  .forEach(Name->{
					  Patient patient=new Patient();
					  patient.setNom(Name);
					  patient.setDateNaissance(new Date());
					  patient.setMalade(false);
					  hospitalService.savePatient(patient);
						  }


				  );
		  Stream.of("adnan","widad","anass")
				  .forEach(Name->{
					  Medecin medecin=new Medecin();
					  medecin.setNom(Name);
					  medecin.setEmail(Name+"@gmail.com");
					  medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
					  hospitalService.saveMedcin(medecin);
						  }


				  );

          Patient patient=patientRepository.findById(1L).orElse(null);
		  Patient patient1=patientRepository.findByNom("aymen");

		  Medecin medecin=medecinRepository.findByNom("adnan");
		  RendezVous rendezVous =new RendezVous();
		  rendezVous.setDate(new Date());
		  rendezVous.setStatus(StatusRDV.PENDING);
		  rendezVous.setMedecin(medecin);
		  rendezVous.setPatient(patient);
		  RendezVous savedRDV=hospitalService.saveRDV(rendezVous);
		  System.out.println(savedRDV.getId());

		  RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
		  Consultation consultation=new Consultation();
		  consultation.setDateConsultation(new Date());
		  consultation.setRendezVous(rendezVous1);
		  consultation.setRapport("Rapport de la consultation....");
		  hospitalService.saveConsultation(consultation);



	             };
	}
}
