package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entites.Emoji;
import tn.esprit.spring.services.IEmojiService;

@RestController
@RequestMapping("/api/test")
public class EmojiRestController {
	

	@Autowired
	IEmojiService EmojiService; // interface
	
	@GetMapping("/retrieveAllEmojis")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllEmojis
	public List<Emoji> getEmojis(){
		List<Emoji> list =  EmojiService.retrieveAllEmojis();
		return list;
	}
	

	@GetMapping("/retrieveEmoji/{Emoji-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveEmoji/{Emoji-id}
	public Emoji retrieveEmoji(@PathVariable("Emoji-id") Long EmojiId){
		Emoji c =  EmojiService.retrieveEmoji(EmojiId);
		return c;
	}
	
	
	@PostMapping("/addEmoji")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addEmoji
	public Emoji addEmoji (@RequestBody Emoji newEmoji) {
		return EmojiService.addEmoji(newEmoji);
		
	}
	
	//http://localhost:8089/SpringMVC/modifyEmoji
	@PutMapping("/modifyEmoji")
	@ResponseBody
	public Emoji modifyEmoji (@RequestBody Emoji Emoji) {
		return EmojiService.updateEmoji(Emoji);
		
	}
	
	//http://localhost:8089/SpringMVC/deleteEmoji/{Emoji-id}
	@DeleteMapping("/deleteEmoji/{Emoji-id}")
	@ResponseBody
	public void deleteEmoji (@PathVariable("Emoji-id") Long EmojiId) {
		 EmojiService.deleteEmojiById(EmojiId);
	}
	
	
	
}
