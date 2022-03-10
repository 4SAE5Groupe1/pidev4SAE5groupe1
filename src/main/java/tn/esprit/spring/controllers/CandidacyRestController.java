package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Candidacy;
import tn.esprit.spring.entites.Nationality;
import tn.esprit.spring.entites.Status;
import tn.esprit.spring.services.EmailSenderService;
import tn.esprit.spring.services.ICandidacy;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("/api/test")

public class CandidacyRestController {
	@Autowired
	ICandidacy candidacyService;
	@Autowired
	private EmailSenderService service;



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
	public Candidacy addCandidacy(@RequestBody Candidacy c) throws MessagingException{

			Candidacy candidacy = candidacyService.addCandidacy(c);
			service.sendEmailWithAttachment("jlidi.achref@esprit.tn",
					"Madame Monsieur"
					+ " Je suis actuellement étudiant (ou élève) en (précisez la formation, la classe)."
							
					
					+ "Je souhaite orienter mon avenir professionnel vers le métier de (précisez).Ce métier me plaît particulièrement en raison de (précisez)."
					+ " J’ai d’ailleurs effectué des stages (ou rencontré des professionnels ou toutes autres expérience justifiant de cet intérêt) dans ce domaine afin de mieux le connaître, et de me rendre compte des qualités qu’il nécessite : (précisez ces qualités)."
					
					+ "Or, j’ai lu avec intérêt la plaquette de présentation (ou parcouru le site Internet) de votre formation et je pense qu’elle pourrait me permettre d’atteindre mon objectif professionnel grâce aux enseignements qu’elle dispense : (précisez)."
					
					+ "Je souhaiterais donc intégrer votre établissement à la rentrée scolaire (précisez l’année)."
					
					
					+ "Je me tiens à votre disposition pour toutes information complémentaire.En vous remerciant d’avance, je vous prie d’agréer, Madame, Monsieur, mes respectueuses salutations."
					
					
					+ "Signature",
					"Candidature à Esprit",
					"C:\\Users\\A\\Desktop\\pidev-backend\\src\\upload\\uploaded.pdf");
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
	

	//http://localhost:8081/SpringMVC/candidacy/FiltrerCandidacyByDateAndNationality/{nat}/{d}
		
	@GetMapping("/FiltrerCandidacyByDateAndNationality/{nat}/{d}")
	@ResponseBody
    public int FiltrerCandidacyByDateAndNationality(@PathVariable Nationality nat, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d){
    	return candidacyService.FiltrerCandidacyByDateAndNationality(nat, d); 
    }
	
	//http://localhost:8081/SpringMVC/candidacy/FiltrerCandidacyByStatus/{statuts}
	
		@GetMapping("/FiltrerCandidacyByStatus/{statuts}")
		@ResponseBody
	    public List<Candidacy> FiltrerCandidacyByStatus(@PathVariable Status statuts){
	    	return candidacyService.FiltrerCandidacyByStatus(statuts); 
	    }
}
