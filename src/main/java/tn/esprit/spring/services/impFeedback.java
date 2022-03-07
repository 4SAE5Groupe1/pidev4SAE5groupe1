package tn.esprit.spring.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.Exit;
import tn.esprit.spring.entites.Feedback;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.FeedbackRepo;
import tn.esprit.spring.repositories.UserRepo;

@Service
public class impFeedback implements Ifeedback{

	@Autowired
	FeedbackRepo feedbackRepo ;
	@Autowired
	UserRepo userRepo ;
	@Override
	public void AddFeedback(Feedback feedback, User user) {

		boolean verif = false ;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
            		"./src/main/resources/badWords.txt"));
            String line = reader.readLine();
            while (line != null) {
                if (feedback.getFeedbackbody().contains(line))
                {
                    System.out.println("You are using bad words");
                    verif = true ;
                }
                // read next line
                line = reader.readLine();
            }
            if(verif==false){
        		feedback.setDateFeedback(new Date());
        		feedback.setUser(user);
        		feedback = feedbackRepo.save(feedback);
            }
            reader.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	
	}

	@Override
	public void deleteFeedback(int id) {
		// TODO Auto-generated method stub
		this.feedbackRepo.deleteById(id);
	}

	@Override
	public List<Feedback> getAllFeedBacks() {
		// TODO Auto-generated method stub
		return feedbackRepo.findAll();
	}

}
