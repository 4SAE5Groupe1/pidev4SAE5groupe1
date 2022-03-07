package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Quiz;


public interface IQuiz {


	List <Quiz> retriveAllQuizs();
	
	Quiz AddQuiz(Quiz q) ;
	
	Quiz UpdateQuiz(Quiz q);
	
	Quiz retriveQuiz(int q);
	
	void DeleteQuiz(int q);
	
	public void assignQuestionToQuizById(Integer Idquestion ,Integer Id);
	
	public void assignQuestionToQuizByBody(Integer Idquestion ,Integer Id);
	
	int getResult(int iq,int Id);
	
	//public int calculeScore(int idQuiz );
	
	Quiz makeQuizaumatique(Integer Id);
}
