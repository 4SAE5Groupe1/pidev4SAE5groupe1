package tn.esprit.spring.controllers;

import java.util.List;

import javax.validation.Valid;

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

import tn.esprit.spring.services.Service;
import tn.esprit.spring.services.SmsRequest;
import tn.esprit.spring.entites.Establishment;
import tn.esprit.spring.services.IEstablishment;

@RestController
@RequestMapping("/establishment")
public class EstablishmentRestController {
	 private final Service service;

	    @Autowired
	    public EstablishmentRestController(Service service) {
	        this.service = service;
	    }

	    
	@Autowired
	IEstablishment establishmentService;
	// http://localhost:8081/SpringMVC/establishment/retrieve-all-establishments

	@GetMapping("/retrieve-all-establishments")
	@ResponseBody
	public List<Establishment> getEstablishments() {

		List<Establishment> listEstablishments = establishmentService.retriveAllEstablishments();
		return listEstablishments;
	}
	
	// http://localhost:8081/SpringMVC/establishment/retrieve-establishment/8

	@GetMapping("/retrieve-establishment/{establishment-id}")
	@ResponseBody
	public Establishment retrieveEstablishment(@PathVariable("establishment-id") int establishmentId) {
			return establishmentService.retriveEstablishment(establishmentId);
			}

	// http://localhost:8081/SpringMVC/establishment/add-establishment

	@PostMapping("/add-establishment")
	@ResponseBody
	public Establishment addEstablishment(@RequestBody Establishment c){

			Establishment establishment = establishmentService.addEstablishment(c);
			return establishment;
		
			}
	
	// http://localhost:8081/SpringMVC/establishment/remove-establishment/{establishment-id}

	@DeleteMapping("/remove-establishment/{establishment-id}")
	@ResponseBody
	public void removeEstablishment(@PathVariable("establishment-id") int establishmentId) {

			establishmentService.deleteEstablishment(establishmentId);
		
			}

	// http://localhost:8081/SpringMVC/establishment/modify-establishment

	@PutMapping("/modify-establishment")
	@ResponseBody
	public Establishment modifyEstablishment(@RequestBody Establishment establishment) {

				return establishmentService.updateEstablishment(establishment);
			}
	// http://localhost:8081/SpringMVC/establishment/sendSMS
	    @PostMapping("/sendSMS")
	    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
	        service.sendSms(smsRequest);
	    }
}
