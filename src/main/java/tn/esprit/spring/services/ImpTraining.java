package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entites.Training;
import tn.esprit.spring.repositories.TrainingRepo;

@Service
public class ImpTraining implements Itraining{

	@Autowired
	TrainingRepo trainingRepo ;
	
	@Override
	public List<Training> retriveAllTrainings() {
		// TODO Auto-generated method stub
		List<Training> list = (List<Training>)trainingRepo.findAll();
		return list;
	}

	@Override
	public Training AddTraining(Training t) {
		// TODO Auto-generated method stub
		Training training = trainingRepo.save(t);
		return training ;
	}

	@Override
	public Training UpdateTraining(Training t) {
		// TODO Auto-generated method stub
		return 	trainingRepo.save(t);
		
	}

	@Override
	public Training retriveTraining(int id) {
		// TODO Auto-generated method stub
		 Training training =trainingRepo.findById(id).orElse(null);
		 return training;
	}

	@Override
	public void DeleteTraining(int id) {
		// TODO Auto-generated method stub
		trainingRepo.deleteById(id);
	}

}
