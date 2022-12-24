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


import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.service.IOffreService;





@RestController
@RequestMapping("/offre")

public class OffreController {
	
	@Autowired
	IOffreService offreService;	
	
	
	@PostMapping("/add-offre")
	public void addOffre(@RequestBody Offre f) {
		offreService.addOffre(f);

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
	

}
