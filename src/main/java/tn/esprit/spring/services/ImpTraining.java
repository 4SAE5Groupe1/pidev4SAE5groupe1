package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entites.Training;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.TrainingRepo;
import tn.esprit.spring.repositories.UserRepo;


@Service
public class ImpTraining implements Itraining{

	@Autowired
	TrainingRepo trainingRepo ;
	@Autowired
	UserRepo userRepo ;
	
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
	
	@Override
	public void ajouterEtaffecterTrainingToTrainer(List<Training> lt, int iduser) {
		// TODO Auto-generated method stub
		
		User user = userRepo.findById(iduser).orElse(null);
		int nbrTrainer = user.getTrainings().size();
		for(Training training :lt)
		{
			if(nbrTrainer<2){
				training.setUser(user);
				trainingRepo.saveAll(lt);
			}else
			{
				System.out.println("the trainer can have a maximum of 2 trainings");
			}
			
		}
		
		
	}

	@Override
	@Transactional
	public void affecterTrainingToTrainer(Training training, int iduser) {
		// TODO Auto-generated method stu 

		User user = userRepo.findById(iduser).orElse(null);
		trainingRepo.save(training);
		userRepo.save(user);
		int nbrTrainer = user.getTrainings().size();
	    if(nbrTrainer<2)
		{
			user.getTrainings().add(training);
	
			trainingRepo.save(training);
			userRepo.save(user);
	}
		
	}

	@Override
	public List<Training> FiltrerTrainingBystartDate(Date d) {
		// TODO Auto-generated method stub
		 
		  List<Training> list = trainingRepo.FiltrerTrainingBystartDate(d) ;
		  return list ;
	}

	@Override
	public List<Training> FiltrerTrainingBydomain(String d) {
		// TODO Auto-generated method stub
		 List<Training> list = trainingRepo.FiltrerTrainingBydomain(d);
		  return list ;
	}

}
