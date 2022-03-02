package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Services.EventService;
import tn.esprit.spring.entites.Categorieevent;
import tn.esprit.spring.entites.Event;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService ;
// ajouter un evenement et l'affecter a une categorie :
    @PostMapping("/addEvennt/{idCategorieEvent}")
    public ResponseEntity<Event> ajouterproduit(@RequestBody Event event, @PathVariable Integer idCategorieEvent){
        Event result =eventService.ajouteretaffecterevent(event,idCategorieEvent);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    // liste des evenements :
    @GetMapping("/listdesEvent")
    public ResponseEntity<List<Event>> listdesevent(){
        List<Event> result = eventService.ListofEvents();
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
// affecter evenement a une categorie
    @PutMapping("/affcterEventToCategorie/{idevent}/{idCategorieEvent}")
    public  ResponseEntity<Event>affecterproduittostock(@PathVariable("idevent") Integer idevent , @PathVariable ("idCategorieEvent") Integer idCategorieEvent ){
        eventService.affecter(idevent,idCategorieEvent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //recherche evenement par id :
    @GetMapping("/listdesEvents/{id}")
    public ResponseEntity<Event> getcategorieByid(@PathVariable Integer id){

        Event result = eventService.findEventById(id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    //participer a un evenement :
    @PostMapping ("/Participer/{idevent}/{id}")
    public  ResponseEntity<Event>participeEvent(@PathVariable("idevent") Integer idevent , @PathVariable ("id") Integer id ){
        eventService.participerevent(idevent,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
