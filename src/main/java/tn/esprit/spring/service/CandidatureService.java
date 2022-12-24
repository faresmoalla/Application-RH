package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Candidature;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.repository.CandidatureRepository;

@Service
public class CandidatureService implements ICandidatureService {

	
	@Autowired
	CandidatureRepository candidatureRepo;
	
	@Override
	public void addCandidature(Candidature candidat) {		
		candidatureRepo.save(candidat);
		 
	}

	@Override
	public void deleteCandidature( Long idCandidature) {
		candidatureRepo.deleteById(idCandidature);
		
	}

	@Override
	public List<Candidature> listAllCandidature(){
		return candidatureRepo.findAll();
		
	}
/*
	@Override
	public void updateCandidature(Candidature candidature, Long idCandidature) {
		
		
		Candidature candidat = candidatureRepo.findById(idCandidature).orElse(null);	
		candidat.setCandidatureId(idCandidature);
		
		
		candidatureRepo.save(candidat);
		
	}	*/
	
	
}
