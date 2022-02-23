package tn.esprit.spring.controllers;

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

import tn.esprit.spring.entites.Candidacy;
import tn.esprit.spring.services.ICandidacy;



@RestController
@RequestMapping("/candidacy")
public class CandidacyRestController {
	@Autowired
	ICandidacy candidacyService;

	// http://localhost:8081/SpringMVC/candidacy/retrieve-all-candidacys

	@GetMapping("/retrieve-all-candidacys")
	@ResponseBody
	public List<Candidacy> getCandidacys() {

		List<Candidacy> listCandidacys = candidacyService.retriveAllCandidacys();
		return listCandidacys;
	}
	
	// http://localhost:8081/SpringMVC/candidacy/retrieve-candidacy/8

	@GetMapping("/retrieve-candidacy/{candidacy-id}")
	@ResponseBody
	public Candidacy retrieveCandidacy(@PathVariable("candidacy-id") int candidacyId) {
			return candidacyService.retriveCandidacy(candidacyId);
			}

	// http://localhost:8081/SpringMVC/candidacy/add-candidacy

	@PostMapping("/add-candidacy")
	@ResponseBody
	public Candidacy addCandidacy(@RequestBody Candidacy c){

			Candidacy candidacy = candidacyService.addCandidacy(c);
			return candidacy;
		
			}
	
	// http://localhost:8081/SpringMVC/candidacy/remove-candidacy/{candidacy-id}

	@DeleteMapping("/remove-candidacy/{candidacy-id}")
	@ResponseBody
	public void removeCandidacy(@PathVariable("candidacy-id") int candidacyId) {

			candidacyService.deleteCandidacy(candidacyId);
		
			}

	// http://localhost:8081/SpringMVC/candidacy/modify-candidacy

	@PutMapping("/modify-candidacy")
	@ResponseBody
	public Candidacy modifyCandidacy(@RequestBody Candidacy candidacy) {

				return candidacyService.updateCandidacy(candidacy);
			}
}
