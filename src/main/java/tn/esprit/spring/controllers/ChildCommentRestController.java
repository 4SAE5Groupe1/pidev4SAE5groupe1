package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.ChildComment;
import tn.esprit.spring.services.IChildCommentService;

@RestController
public class ChildCommentRestController {
	

	@Autowired
	IChildCommentService childCommentService; // interface
	
	@GetMapping("/retrieveAllChildComments")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllChildComments
	public List<ChildComment> getChildComments(){
		List<ChildComment> list =  childCommentService.retrieveAllChildComments();
		return list;
	}
	

	@GetMapping("/retrieveChildComment/{ChildComment-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveChildComment/{ChildComment-id}
	public ChildComment retrieveChildComment(@PathVariable("ChildComment-id") Long ChildCommentId){
		ChildComment c =  childCommentService.retrieveChildComment(ChildCommentId);
		return c;
	}
	
	
	@PostMapping("/addChildComment")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addChildComment
	public ChildComment addChildComment (@RequestBody ChildComment newChildComment) {
		return childCommentService.addChildComment(newChildComment);
		
	}
	
	//http://localhost:8089/SpringMVC/modifyChildComment
	@PutMapping("/modifyChildComment")
	@ResponseBody
	public ChildComment modifyChildComment (@RequestBody ChildComment ChildComment) {
		return childCommentService.updateChildComment(ChildComment);
		
	}
	
	//http://localhost:8089/SpringMVC/deleteChildComment/{ChildComment-id}
	@DeleteMapping("/deleteChildComment/{ChildComment-id}")
	@ResponseBody
	public void deleteChildComment (@PathVariable("ChildComment-id") Long ChildCommentId) {
		childCommentService.deleteChildCommentById(ChildCommentId);
	}
	
	
	
}
