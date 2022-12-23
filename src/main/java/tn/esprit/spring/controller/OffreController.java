package tn.esprit.spring.controller;
import java.util.Date;
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
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.service.OffreService;




@RestController
@RequestMapping("/offre")
@Api(tags = "Gestion Offre")
public class OffreController {
	
	@Autowired
	OffreService offreService;	
	
	@ApiOperation(value = "Ajouter Offre")
	@PostMapping("/add-offre")
	public void addOffre(@RequestBody Offre f) {
		offreService.addOffre(f);

	}	
	
	@ApiOperation(value = "Supprimer Offre")
	@DeleteMapping("/supprimer-offre")
	@ResponseBody
	public void deleteOffre(
			@PathVariable("idOffre") Long idOffre) {
		offreService.deleteOffre(idOffre);

	}
	
	@ApiOperation(value = "Afficher Offre ")
	@GetMapping("/GetOffre")
	public List<Offre> getOffre() {

	

		return offreService.listAllOffre();

	}
	
	@ApiOperation(value = "Modifier Offre")
	@PutMapping("/{idOffre}")
	public void UpdateOffre(@RequestBody Offre f, @PathVariable("idOffre") Long idOffre)
			 {
		offreService.updateOffre(f, idOffre);

	}
	

}
