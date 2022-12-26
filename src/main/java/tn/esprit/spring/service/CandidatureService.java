package tn.esprit.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Candidature;
import tn.esprit.spring.entity.FileDB;

import tn.esprit.spring.repository.CandidatureRepository;
import tn.esprit.spring.repository.FileDBRepository;

@Service
public class CandidatureService implements ICandidatureService {

	
	@Autowired
	CandidatureRepository candidatureRepo;
	@Autowired
	FileDBRepository fileRepo;
	
	@Override
	public Candidature addCandidature(Candidature candidat) {		
		return candidatureRepo.save(candidat);
		 
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

	@Override
	public FileDB affecterfileCandidature(Long idCandidature, Long idfile) {
		Candidature u = candidatureRepo.findById(idCandidature).orElse(null);
		FileDB f = fileRepo.findById(idfile).orElse(null);
		f.getCandidature().add(u);
		return fileRepo.save(f);
		
	}
	
	
}
