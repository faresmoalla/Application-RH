package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Offre;

public interface IOffreService {
	public void addOffre(Offre offre);
	public void deleteOffre( Long idOffre);
	public List<Offre> listAllOffre();
	public void updateOffre(Offre offre, Long idOffre);
}
