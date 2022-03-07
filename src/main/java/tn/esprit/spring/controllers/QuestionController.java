package tn.esprit.spring.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.QuestionQuiz;
import tn.esprit.spring.services.Iquestion;

@RestController
public class QuestionController {
	@Autowired
	Iquestion QuestionService ;
	
	// http://localhost:8081/SpringMVC/GetUQuestionQuizs
		@GetMapping("/GetUQuestionQuizs") // convert objet java to json
		@ResponseBody
		public List<QuestionQuiz> GetUsers() {
			List<QuestionQuiz> list = (List<QuestionQuiz>)QuestionService.GetQuestions();
			return list;
		}
		
		// http://localhost:8081/SpringMVC/retrieve-QuestionQuiz/
		@GetMapping("/retrieve-QuestionQuiz/{QuestionQuiz-id}")
		@ResponseBody
		public QuestionQuiz retrieveQuiz(@PathVariable("QuestionQuiz-id") int QuestionQuizId) {
			return QuestionService.GetQuestion(QuestionQuizId);
		}
		
		// http://localhost:8081/SpringMVC/addQuestionQuiz/
		@PostMapping("/addQuestionQuiz") // convert json to java object
		@ResponseBody
		public QuestionQuiz addQuestionQuiz(@RequestBody QuestionQuiz q) {
			QuestionQuiz questionQuiz = QuestionService.addQuestion(q);
			return  questionQuiz;	
		}
		
		// http://localhost:8081/SpringMVC/verifeResponse/
		@PostMapping("/verifeResponse/{idquestion}/{idResponse}") // convert json to java object
		@ResponseBody
		public boolean verifeResponse(@PathVariable("idResponse") int idResponse ,@PathVariable("idquestion") int idquestion
				)
		{
			return QuestionService.verifeResponse(idResponse, idquestion);
		}

}
