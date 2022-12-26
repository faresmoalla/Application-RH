package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Offre;

import tn.esprit.spring.repository.OffreRepository;

@Service
public class OffreService implements IOffreService {
	
		@Autowired
		OffreRepository offreRepo;
	

		
		@Override
		public Offre addOffre(Offre offre) {		
			return offreRepo.save(offre);
			 
		}

		@Override
		public void deleteOffre( Long idOffre) {
			offreRepo.deleteById(idOffre);
			
		}

		@Override
		public List<Offre> listAllOffre(){
			return offreRepo.findAll();
			
		}
	
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

		@Override
		public Offre affichDetailoffre(Long idOffre) {
			// TODO Auto-generated method stub
			return offreRepo.findById(idOffre).orElse(null);
		}

		
		
		
	
		
	

		
	



	}

