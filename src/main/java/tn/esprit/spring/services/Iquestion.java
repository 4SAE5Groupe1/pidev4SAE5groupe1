package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entites.QuestionQuiz;



public interface Iquestion {
	List<QuestionQuiz> GetQuestions() ;
	
	QuestionQuiz GetQuestion(int id) ;
	
	QuestionQuiz addQuestion(QuestionQuiz q) ;
	
	QuestionQuiz UpdateQuestion (QuestionQuiz q);
	
	void DeleteQuestion(int id) ;
	
	public boolean verifeResponse(int idResponse , int idquestion) ;
}
