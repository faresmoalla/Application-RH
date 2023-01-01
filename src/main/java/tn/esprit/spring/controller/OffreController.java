package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IOffreService;





@RestController
@RequestMapping("/offre")
@CrossOrigin(origins = "*",exposedHeaders="Access-Control-Allow-Origin" )

public class OffreController {
	
	@Autowired
	IOffreService offreService;	
	
	
	@PostMapping("/add-offre")
	public Offre addOffre(@RequestBody Offre f) {
		return offreService.addOffre(f);

	}	
	
	
	@DeleteMapping("/supprimer-offre/{idOffre}")
	@ResponseBody
	public void deleteOffre(
			@PathVariable("idOffre") Long idOffre) {
		offreService.deleteOffre(idOffre);

	}
	
	
	@GetMapping("/getAllOffre")
	public List<Offre> getAllOffre() {

	

		return offreService.listAllOffre();

	}
	
	
	@PutMapping("/{idOffre}")
	public void UpdateOffre(@RequestBody Offre f, @PathVariable("idOffre") Long idOffre)
			 {
		offreService.updateOffre(f, idOffre);

	}
	@GetMapping("/get-offre/{id-offre}")
	@ResponseBody
	public Offre getuserbyid(@PathVariable("id-offre") Long idoffre) {
		return offreService.affichDetailoffre(idoffre);

	}
	
	@PutMapping("/affecter-file-offre/{idO}/{id-file}")
	@ResponseBody
	public FileDB affecterfilecanditature(@PathVariable("idO") Long idO,@PathVariable("id-file") Long idfile) {
		return offreService.affecterfileOffre(idO, idfile);

	}

}
