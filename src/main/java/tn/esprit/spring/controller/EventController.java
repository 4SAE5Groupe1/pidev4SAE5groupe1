package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Services.EventService;
import tn.esprit.spring.entites.Event;

@RestController
public class EventController {
    @Autowired
    private EventService eventService ;

    @PostMapping("/addEvennt/{idCategorieEvent}")
    public ResponseEntity<Event> ajouterproduit(@RequestBody Event event, @PathVariable Integer idCategorieEvent){
        Event result =eventService.ajouteretaffecterevent(event,idCategorieEvent);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }



}
