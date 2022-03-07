package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.QuestionQuiz;
import tn.esprit.spring.entites.ResponseLearner;
import tn.esprit.spring.repositories.QuestionRepo;
import tn.esprit.spring.repositories.ResponseRepo;

@Service
public class ImpResponse implements IResponse{

	@Autowired
	ResponseRepo responseRepo ;
	@Autowired
	QuestionRepo questionRepo ;
	@Override
	public List<ResponseLearner> retriveAllResponseLearners() {
		// TODO Auto-generated method stub
		List<ResponseLearner> list = responseRepo.findAll();
		return list;
	}

	@Override
	public ResponseLearner AddResponseLearner(ResponseLearner r) {
		// TODO Auto-generated method stub
		ResponseLearner responseLearner = responseRepo.save(r);
		return responseLearner;
	}

	@Override
	public ResponseLearner UpdateResponseLearner(ResponseLearner r) {
		// TODO Auto-generated method stub
		return responseRepo.save(r);
	}

	@Override
	public ResponseLearner retriveResponseLearner(int id) {
		// TODO Auto-generated method stub
		ResponseLearner responseLearner =responseRepo.findById(id).orElse(null);
		return responseLearner;
	}

	@Override
	public void DeleteResponseLearner(int id) {
		// TODO Auto-generated method stub
		responseRepo.deleteById(id);
	}
	
	public void ajouterEtaffecterResponseToQuestion(ResponseLearner r, int idQuestion) {
		// TODO Auto-generated method stub
		ResponseLearner responseLearner = responseRepo.save(r);
		QuestionQuiz questionQuiz = questionRepo.findById(idQuestion).orElse(null);
		responseLearner.setQuestionQuiz(questionQuiz);
		responseRepo.save(responseLearner) ;
		
	}

}
