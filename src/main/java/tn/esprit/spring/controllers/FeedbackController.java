package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Feedback;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.Ifeedback;
import tn.esprit.spring.services.Iuser;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class FeedbackController {

	@Autowired
	Ifeedback IfeedbackService ;
	@Autowired
	Iuser userService ;
	
	// http://localhost:8081/SpringMVC/GetFeedbacks
	@GetMapping("/GetFeedbacks") // convert objet java to json
	@ResponseBody
	public List<Feedback> GetFeedbacks() {
		List<Feedback> list = IfeedbackService.getAllFeedBacks();
		return list;
	}
	
    // http://localhost:8081/SpringMVC/send-Feedback/1
    @PostMapping("/send-Feedback/{Userid}")
    public void sendFeedback(@RequestBody Feedback feedback,@PathVariable("Userid") User user) {
         IfeedbackService.AddFeedback(feedback, user);
    }
    
    // localhost:8081/SpringMVC/remove-Feedback/{Feedback-id}
    @DeleteMapping("/remove-Feedback/{Feedback-id}")
    @ResponseBody
    public  void deletemessage(@PathVariable("Feedback-id") int Id) {
    	IfeedbackService.deleteFeedback(Id);
    }
}
