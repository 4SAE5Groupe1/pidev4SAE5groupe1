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

import tn.esprit.spring.entites.Comment;
import tn.esprit.spring.services.ICommentService;

@RestController
public class CommentRestController {
	

	@Autowired
	ICommentService commentService; // interface
	
	@GetMapping("/retrieveAllComments")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllComments
	public List<Comment> getComments(){
		List<Comment> list =  commentService.retrieveAllComments();
		return list;
	}
	

	@GetMapping("/retrieveComment/{Comment-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveComment/{Comment-id}
	public Comment retrieveComment(@PathVariable("Comment-id") Long CommentId){
		Comment c =  commentService.retrieveComment(CommentId);
		return c;
	}
	
	
	@PostMapping("/addComment")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addComment
	public Comment addComment (@RequestBody Comment newComment) {
		return commentService.addComment(newComment);
		
	}
	
	//http://localhost:8089/SpringMVC/modifyComment
	@PutMapping("/modifyComment")
	@ResponseBody
	public Comment modifyComment (@RequestBody Comment Comment) {
		return commentService.updateComment(Comment);
		
	}
	
	//http://localhost:8089/SpringMVC/deleteComment/{Comment-id}
	@DeleteMapping("/deleteComment/{Comment-id}")
	@ResponseBody
	public void deleteComment (@PathVariable("Comment-id") Long CommentId) {
		commentService.deleteCommentById(CommentId);
	}
	
	
	
}
