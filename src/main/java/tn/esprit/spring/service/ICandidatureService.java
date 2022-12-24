package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Candidature;

public interface ICandidatureService {
	public void addCandidature(Candidature candidat);
	public void deleteCandidature( Long idCandidature);
	public List<Candidature> listAllCandidature();
	//public void updateCandidature(Candidature candidature, Long idCandidature);
	
	
}
