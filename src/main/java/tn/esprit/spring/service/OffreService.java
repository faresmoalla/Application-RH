package tn.esprit.spring.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.entity.TypeOffre;
import tn.esprit.spring.repository.OffreRepository;

@Service
public class OffreService implements IOffreService {
	

	
		@Autowired
		OffreRepository offreRepo;
	

	/////////////////////////Ajout Offre//////////////////
		
		@Override
		public void addOffre(Offre offre) {
			
			offreRepo.save(offre);

			 
		}

	///////////////////////Delete Offre//////////////////////
		@Override
		public void deleteOffre( Long idOffre) {

			
		
			
			offreRepo.deleteById(idOffre);
			
		}

		@Override
		public List<Offre> listAllOffre(){
			return offreRepo.findAll();
			
		}
	
		///////////////////////Update Offre//////////////////////
		@Override
		public void updateOffre(Offre offre, Long idOffre) {
			Date currentSqlDate = new Date(System.currentTimeMillis());
			Offre off = offreRepo.findById(idOffre).orElse(null);

			
			off.setOffreId(idOffre);
			off.setDatePublication(currentSqlDate);
			off.setTitre(offre.getTitre());
			off.setTypeOffre(offre.getTypeOffre());
			off.setDescription(offre.getDescription());
			off.setAdresse(offre.getAdresse());
			off.setSalaire(offre.getSalaire());
			
			
			
			offreRepo.save(off);
			
		
		}

		
		
		
	
		
	

		
	



	}

