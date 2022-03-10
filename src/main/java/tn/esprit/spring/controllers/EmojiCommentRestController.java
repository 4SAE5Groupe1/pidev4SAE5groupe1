package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.EmojiComment;
import tn.esprit.spring.services.IEmojiCommentService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class EmojiCommentRestController {
	

	@Autowired
	IEmojiCommentService EmojiCommentService; // interface
	
	@GetMapping("/retrieveAllEmojiComments")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllEmojiComments
	public List<EmojiComment> getEmojiComments(){
		List<EmojiComment> list =  EmojiCommentService.retrieveAllEmojisComment();
		return list;
	}
	

	@GetMapping("/retrieveEmojiComment/{EmojiComment-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveEmojiComment/{EmojiComment-id}
	public EmojiComment retrieveEmojiComment(@PathVariable("EmojiComment-id") Long EmojiCommentId){
		EmojiComment c =  EmojiCommentService.retrieveEmojiComment(EmojiCommentId);
		return c;
	}
	
	
	@PostMapping("/addEmojiComment")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addEmojiComment
	public EmojiComment addEmojiComment (@RequestBody EmojiComment newEmojiComment) {
		return EmojiCommentService.addEmojiComment(newEmojiComment);
		
	}
	
	//http://localhost:8089/SpringMVC/modifyEmojiComment
	@PutMapping("/modifyEmojiComment")
	@ResponseBody
	public EmojiComment modifyEmojiComment (@RequestBody EmojiComment EmojiComment) {
		return EmojiCommentService.updateEmojiComment(EmojiComment);
		
	}
	
	//http://localhost:8089/SpringMVC/deleteEmojiComment/{EmojiComment-id}
	@DeleteMapping("/deleteEmojiComment/{EmojiComment-id}")
	@ResponseBody
	public void deleteEmojiComment (@PathVariable("EmojiComment-id") Long EmojiCommentId) {
		 EmojiCommentService.deleteEmojiCommentById(EmojiCommentId);
	}
	
	
	
}
