package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.ResponseLearner;
import tn.esprit.spring.services.IResponse;



@RestController
public class ResponseController {
	@Autowired
	IResponse ResponseService ;

	// http://localhost:8081/SpringMVC/GetResponseLearners
	@GetMapping("/GetResponseLearners") // convert objet java to json
	@ResponseBody
	public List<ResponseLearner> GetResponseLearners() {
		List<ResponseLearner> list = ResponseService.retriveAllResponseLearners();
		return list;
	}
	
	// http://localhost:8081/SpringMVC/retrieve-ResponseLearner/
	@GetMapping("/retrieve-ResponseLearner/{ResponseLearner-id}")
	@ResponseBody
	public ResponseLearner retrieveResponseLearner(@PathVariable("ResponseLearner-id") int ResponseLearnerId) {
		return ResponseService.retriveResponseLearner(ResponseLearnerId);
	}
	
	// http://localhost:8081/SpringMVC/addResponseLearner/
	@PostMapping("/addResponseLearner") // convert json to java object
	@ResponseBody
	public ResponseLearner addQuiz(@RequestBody ResponseLearner r) {
		ResponseLearner responseLearner = ResponseService.AddResponseLearner(r);
		return  responseLearner;	
	}
	
	// http://localhost:8081/SpringMVC/add-ResponseToQuestion/{idQuestion}
	@PostMapping("/add-ResponseToQuestion/{idQuestion}")
	@ResponseBody
	public void ajouterEtaffecterResponseToQuestion(@RequestBody ResponseLearner r,@PathVariable("idQuestion") int idQuestion)
	{
		ResponseService.ajouterEtaffecterResponseToQuestion(r, idQuestion);
	}
}
