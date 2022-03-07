package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.Quiz;
import tn.esprit.spring.services.IQuiz;

@RestController
public class QuizController {
	@Autowired
	IQuiz QuizService ;

	// http://localhost:8081/SpringMVC/GetQuizs
	@GetMapping("/GetQuizs") // convert objet java to json
	@ResponseBody
	public List<Quiz> GetQuizs() {
		List<Quiz> list = QuizService.retriveAllQuizs();
		return list;
	}
	
	// http://localhost:8081/SpringMVC/retrieve-Quiz/
	@GetMapping("/retrieve-Quiz/{Quiz-id}")
	@ResponseBody
	public Quiz retrieveQuiz(@PathVariable("Quiz-id") int QuizId) {
		return QuizService.retriveQuiz(QuizId);
	}
	
	// http://localhost:8081/SpringMVC/addQuiz/
	@PostMapping("/addQuiz") // convert json to java object
	@ResponseBody
	public Quiz addQuiz(@RequestBody Quiz q) {
		Quiz quiz = QuizService.AddQuiz(q);
		return  quiz;	
	}
	
	// http://localhost:8081/SpringMVC/modifyQuiz/
	@PutMapping("/modifyQuiz/{Quiz-id}")
	@ResponseBody
	public Quiz modifyQuiz(@RequestBody Quiz q, @PathVariable("Quiz-id") int QuizId) {
		return QuizService.UpdateQuiz(q);
	}
	
	// http://localhost:8081/SpringMVC/remove-Quiz/
	@DeleteMapping("/remove-Quiz/{Quiz-id}")
	@ResponseBody
	public void removeQuiz(@PathVariable("Quiz-id") int QuizId) {
		QuizService.DeleteQuiz(QuizId);
	}
	
//	// http://localhost:8081/SpringMVC/calculScore/
//	@PostMapping("/calculScore/{QuizId}") // convert json to java object
//	@ResponseBody
//	public void calculeScore(@PathVariable("QuizId") int QuizId){
//		QuizService.calculeScore(QuizId);
//	}
//	
	@PostMapping("/result/{idquiz}/{iduser}")
	public int getresult(@PathVariable("idquiz")int  Iq,@PathVariable("iduser")int Id)
	{
		 return QuizService.getResult(Iq,Id);
		
	}
	
	@GetMapping("/makequiz/{idquiz}")
	public Quiz makequiz(@PathVariable("idquiz") Integer quizid)
	{
		 return QuizService.makeQuizaumatique(quizid);
		
	}
	
}
