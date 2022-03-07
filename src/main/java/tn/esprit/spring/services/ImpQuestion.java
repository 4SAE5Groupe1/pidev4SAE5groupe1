package tn.esprit.spring.services;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entites.QuestionQuiz;
import tn.esprit.spring.entites.ResponseLearner;
import tn.esprit.spring.repositories.QuestionRepo;
import tn.esprit.spring.repositories.QuizRepo;
import tn.esprit.spring.repositories.ResponseRepo;

@Service
public class ImpQuestion implements Iquestion{

	@Autowired
	QuestionRepo QuestionRepo ;
	@Autowired
	ResponseRepo ResponseRepo ;
	@Autowired
	QuizRepo quizRepo ;
	@Override
	public List<QuestionQuiz> GetQuestions() {
		// TODO Auto-generated method stub
		List<QuestionQuiz> list = QuestionRepo.findAll();
		return list;
	}

	@Override
	public QuestionQuiz GetQuestion(int id) {
		// TODO Auto-generated method stub
		QuestionQuiz questionQuiz = QuestionRepo.findById(id).orElse(null);
		return questionQuiz;
	}

	@Override
	public QuestionQuiz addQuestion(QuestionQuiz q) {
		// TODO Auto-generated method stub
		QuestionQuiz questionQuiz = QuestionRepo.save(q);
		return questionQuiz;
	}

	@Override
	public QuestionQuiz UpdateQuestion(QuestionQuiz q) {
		// TODO Auto-generated method stub
		return QuestionRepo.save(q);
	}

	@Override
	public void DeleteQuestion(int id) {
		// TODO Auto-generated method stub
		QuestionRepo.deleteById(id);
	}
	
	public boolean verifeResponse(int idResponse , int idquestion){
		QuestionQuiz question = QuestionRepo.findById(idquestion).orElse(null);
		ResponseLearner response = ResponseRepo.findById(idResponse).orElse(null);
		
		if(question.getCorrectResponse().equals(response.getResponseBody()))
		{
				
			return true ;
		}else
			return false;
	}



}
