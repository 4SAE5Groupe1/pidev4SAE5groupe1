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

import tn.esprit.spring.entites.ForbiddenWord;
import tn.esprit.spring.services.IForbiddenWordService;

@RestController
public class ForbiddenWordRestController {
	

	@Autowired
	IForbiddenWordService forbiddenWordService; // interface
	
	@GetMapping("/retrieveAllForbiddenWords")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllForbiddenWords
	public List<ForbiddenWord> getForbiddenWords(){
		List<ForbiddenWord> list =  forbiddenWordService.retrieveAllForbiddenWords();
		return list;
	}
	

	@GetMapping("/retrieveForbiddenWord/{ForbiddenWord-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveForbiddenWord/{ForbiddenWord-id}
	public ForbiddenWord retrieveForbiddenWord(@PathVariable("ForbiddenWord-id") Long ForbiddenWordId){
		ForbiddenWord c =  forbiddenWordService.retrieveForbiddenWord(ForbiddenWordId);
		return c;
	}
	
	
	@PostMapping("/addForbiddenWord")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addForbiddenWord
	public ForbiddenWord addForbiddenWord (@RequestBody ForbiddenWord newForbiddenWord) {
		return forbiddenWordService.addForbiddenWord(newForbiddenWord);
		
	}
	
	//http://localhost:8089/SpringMVC/modifyForbiddenWord
	@PutMapping("/modifyForbiddenWord")
	@ResponseBody
	public ForbiddenWord modifyForbiddenWord (@RequestBody ForbiddenWord ForbiddenWord) {
		return forbiddenWordService.updateForbiddenWord(ForbiddenWord);
		
	}
	
	//http://localhost:8089/SpringMVC/deleteForbiddenWord/{ForbiddenWord-id}
	@DeleteMapping("/deleteForbiddenWord/{ForbiddenWord-id}")
	@ResponseBody
	public void deleteForbiddenWord (@PathVariable("ForbiddenWord-id") Long ForbiddenWordId) {
		forbiddenWordService.deleteForbiddenWordById(ForbiddenWordId);
	}
	
	
	
}
