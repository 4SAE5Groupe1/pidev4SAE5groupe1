package tn.esprit.spring.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.Training;
import tn.esprit.spring.services.Itraining;

@RestController
public class TrainingController {
	
	@Autowired
	Itraining TrainingService ;
	
	// http://localhost:8081/SpringMVCt/GetTrainings
	@GetMapping("/GetTrainings") // convert objet java to json
	@ResponseBody
	public List<Training> GetTrainings() {
		List<Training> list = TrainingService.retriveAllTrainings();
		return list;
	}
	
	// http://localhost:8081/SpringMVC/retrieve-Training/
	@GetMapping("/retrieve-Training/{Training-id}")
	@ResponseBody
	public Training retrieveTraining(@PathVariable("Training-id") int TrainingId) {
		return TrainingService.retriveTraining(TrainingId);
	}
	
	// http://localhost:8081/SpringMVC/addTraining/
	@PostMapping("/addTraining") // convert json to java object
	@ResponseBody
	public Training addTraining(@RequestBody Training t) {
		Training training = TrainingService.AddTraining(t);
		return  training;
		
	}
	
	// http://localhost:8081/SpringMVC/modifyTraining/
	@PutMapping("/modifyTraining/{Training-id}")
	@ResponseBody
	public Training modifyTraining(@RequestBody Training t, @PathVariable("Training-id") int TrainingId) {
		return TrainingService.UpdateTraining(t);
	}
	
	// http://localhost:8081/SpringMVC/remove-Training/
	@DeleteMapping("/remove-Training/{Training-id}")
	@ResponseBody
	public void removeTraining(@PathVariable("Training-id") int TrainingId) {
		TrainingService.DeleteTraining(TrainingId);
	}
	
	// http://localhost:8081/SpringMVC/add-ListeTrainings/{idUser}
	@PostMapping("/add-ListeTrainings/{idUser}")
	@ResponseBody
	public void ajouterEtaffecterListeTraining(@RequestBody List<Training> lt,@PathVariable("idUser") int idUser)
	{
		TrainingService.ajouterEtaffecterTrainingToTrainer(lt, idUser);
	}
	
	// http://localhost:8081/SpringMVC/add-ListeTrainings/{idUser}
	@PostMapping("/affecterTrainingToTrainer/{idUser}")
	@ResponseBody
	public void affecterTrainingToTrainer(@RequestBody Training training,@PathVariable("idUser") int idUser)
	{
		TrainingService.affecterTrainingToTrainer(training, idUser);
	}
	
	// http://localhost:8081/SpringMVC//FiltrerTrainingBystartDate/{d}
	@GetMapping("/FiltrerTrainingBystartDate/{d}")
	@ResponseBody
	public List<Training> FiltrerTrainingBystartDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d)
	{
		return TrainingService.FiltrerTrainingBystartDate(d);
	}
	
	// http://localhost:8081/SpringMVC//FiltrerTrainingByDomaine/{d}
	@GetMapping("/FiltrerTrainingByDomaine/{d}")
	@ResponseBody
	public List<Training> FiltrerTrainingByDomaine(@PathVariable("d") String d)
	{
		return TrainingService.FiltrerTrainingBydomain(d);
	}
	
}
