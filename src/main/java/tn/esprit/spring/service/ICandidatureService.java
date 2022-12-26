package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Candidature;
import tn.esprit.spring.entity.FileDB;

public interface ICandidatureService {
	public Candidature addCandidature(Candidature candidat);
	public void deleteCandidature( Long idCandidature);
	public List<Candidature> listAllCandidature();
	public FileDB affecterfileCandidature(Long idCandidature,Long idfile);
	//public void updateCandidature(Candidature candidature, Long idCandidature);
	
	
}
