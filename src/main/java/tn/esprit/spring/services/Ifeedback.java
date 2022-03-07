package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Feedback;
import tn.esprit.spring.entites.User;

public interface Ifeedback {

	List<Feedback> getAllFeedBacks();
	void AddFeedback(Feedback feedback, User user);
    void deleteFeedback(int id);
}
