package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Establishment;
import tn.esprit.spring.services.IEstablishment;
import tn.esprit.spring.services.Service;
import tn.esprit.spring.services.SmsRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/test")
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
	public Establishment addEstablishment(@RequestBody Establishment c) {

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

	// http://localhost:8081/SpringMVC/establishment/FiltrerEstablishmentByName/{name}

	@GetMapping("/FiltrerEstablishmentByName/{name}")
	@ResponseBody
	public List<Establishment> FiltrerEstablishmentByName(@PathVariable String name) {
		return establishmentService.FiltrerEstablishmentByName(name);
	}

	// http://localhost:8081/SpringMVC/establishment/FiltrerEstablishmentBydomain/{domain}

	@GetMapping("/FiltrerEstablishmentBydomain/{domain}")
	@ResponseBody
	public List<Establishment> FiltrerEstablishmentBydomain(@PathVariable String domain) {
		return establishmentService.FiltrerEstablishmentBydomain(domain);
	}

	// http://localhost:8081/SpringMVC/establishment/FiltrerEstablishmentByaddress/{address}

	@GetMapping("/FiltrerEstablishmentByaddress/{address}")
	@ResponseBody
	public List<Establishment> FiltrerEstablishmentByaddress(@PathVariable String address) {
		return establishmentService.FiltrerEstablishmentByaddress(address);
	}
}
