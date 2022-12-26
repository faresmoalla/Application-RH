package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Candidature;
import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.service.ICandidatureService;
import tn.esprit.spring.service.OffreService;

@RestController
@RequestMapping("/candidature")

public class CandidatureController {
	@Autowired
	ICandidatureService candidatService;	
	
	
	@PostMapping("/add-candidature")
	public Candidature addCandidature(@RequestBody Candidature f) {
		return candidatService.addCandidature(f);

	}	
	
	
	@DeleteMapping("/supprimer-candidature/{idCandidature}")
	@ResponseBody
	public void deleteCandidature(
			@PathVariable("idCandidature") Long idCandidature) {
		candidatService.deleteCandidature(idCandidature);

	}
	
	
	@GetMapping("/getAllCandidature")
	public List<Candidature> getAllCandidature() {

	

		return candidatService.listAllCandidature();

	}
	
	/*
	@PutMapping("/{idCandidature}")
	public void UpdateCandidature(@RequestBody Candidature f, @PathVariable("idCandidature") Long idCandidature)
			 {
		candidatService.updateCandidature(f, idCandidature);

	}*/
	@PutMapping("/affecter-file-vehicule/{id-ca}/{id-file}")
	@ResponseBody
	public FileDB affecterfilecanditature(@PathVariable("id-ca") Long idca,@PathVariable("id-file") Long idfile) {
		return candidatService.affecterfileCandidature(idca, idfile);

	}
	
}
