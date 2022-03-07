package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.QuestionQuiz;
import tn.esprit.spring.entites.Quiz;
import tn.esprit.spring.entites.Result;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.QuestionRepo;
import tn.esprit.spring.repositories.QuizRepo;
import tn.esprit.spring.repositories.ResultRepository;
import tn.esprit.spring.repositories.UserRepo;

@Service
public class ImpQuiz implements IQuiz{

	@Autowired
	QuizRepo quizRepo ;
	@Autowired
	QuestionRepo QuestionRepo ;
	@Autowired
	ImpQuestion impQuestion ;
	@Autowired
	UserRepo userRepo ;
	@Autowired
	ResultRepository resultRepository;
	
	@Override
	public List<Quiz> retriveAllQuizs() {
		// TODO Auto-generated method stub
		List<Quiz> list = quizRepo.findAll();
		return list;
	}

	@Override
	public Quiz AddQuiz(Quiz q) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepo.save(q);
		return quiz;
	}

	@Override
	public Quiz UpdateQuiz(Quiz id) {
		// TODO Auto-generated method stub
		return quizRepo.save(id);
	}

	@Override
	public Quiz retriveQuiz(int id) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepo.findById(id).orElse(null);
		return quiz;
	}

	@Override
	public void DeleteQuiz(int id) {
		// TODO Auto-generated method stub
		quizRepo.deleteById(id);
	}

	@Override
	public void assignQuestionToQuizById(Integer Idquestion, Integer Id) {
		// TODO Auto-generated method stub
		Quiz quiz= quizRepo.findById(Id).get();
		QuestionQuiz question = QuestionRepo.findById(Idquestion).get();
		question.setQuiz(quiz);
		QuestionRepo.save(question);
	}

	@Override
	public void assignQuestionToQuizByBody(Integer Idquestion, Integer Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public int getResult(int iq, int Id) {
		// TODO Auto-generated method stub
	User user = userRepo.findById(Id).orElse(null);
	Quiz quiz = quizRepo.findById(iq).orElse(null);
	Set <QuestionQuiz> list =  quiz.getQuestionQuizs();
	int result=0;
	for (QuestionQuiz question :list) {
		
			if(impQuestion.verifeResponse(question.getQuestionId(),
					question.getResponseLearner().getResponseLearnerId()))
			{
				result++;
			}
	}
	Result res=new Result();
	res.setUser(user);
	res.setQuiz(quiz);
	res.setScore(result);
	resultRepository.save(res);
	return result ;
	}

	@Override
	public Quiz makeQuizaumatique(Integer Id) {
		// TODO Auto-generated method stub
		Quiz quiz=quizRepo.findById(Id).get();
		List<QuestionQuiz> ques= (List<QuestionQuiz>) QuestionRepo.findAll();
		List<QuestionQuiz> specif1 = (List<QuestionQuiz>) new ArrayList<QuestionQuiz>();
		for (QuestionQuiz question : ques) {
			if(question.getQuiz().getIdQuiz()==Id)
			{
				specif1.add(question);
				
			}
		}
		Set<QuestionQuiz> specif = (Set<QuestionQuiz>) new HashSet<QuestionQuiz>();
		Random random=new Random();	
		for(int i=0;i<3;i++)
		{
			int rand=random.nextInt(specif1.size());
			specif.add(specif1.get(rand));
			specif1.remove(rand);
		}
		quiz.setQuestionQuizs(specif);		
		return quiz;
	}
	
//	public int calculeScore(int idQuiz ){
//		int scores= 0 ;
//		Quiz quiz = quizRepo.findById(idQuiz).orElse(null);
//		Set<QuestionQuiz> list =  quiz.getQuestionQuizs() ;
//		for(QuestionQuiz question :list)
//		{
//			if(impQuestion.verifeResponse(question.getResponseLearner().getResponseLearnerId(),question.getQuestionId() , idQuiz)==true)
//			{
//				int score = quiz.getScore();
//				scores = score++;
//				
//			}
//				
//		}
//		System.out.println(scores);
//		return scores;
//	}
//	public Quiz getQuestions() {
//		List<QuestionQuiz> allQues = QuestionRepo.findAll();
//		List<QuestionQuiz> qList = new ArrayList<QuestionQuiz>();
//		Quiz quiz = null ;
//		Random random = new Random();
//		
//		for(int i=0; i<5; i++) {
//			int rand = random.nextInt(allQues.size());
//			qList.add(allQues.get(rand));
//			allQues.remove(rand);
//		}
//
//		quiz.setQuestionQuizs((Set<QuestionQuiz>) qList);
//		
//		return quiz;
//	}
	
//	public int getResult(QuestionQuiz questionQuiz) {
//		int correct = 0;
//		Quiz quiz = quizRepo.getById(id) ;
//		for(QuestionQuiz q: quiz.getQuestionQuizs())
//			if(q.getCorrectResponse() == q.getResponseLearner().getResponseBody())
//				correct++;
//		
//		return correct;
//	}

}
