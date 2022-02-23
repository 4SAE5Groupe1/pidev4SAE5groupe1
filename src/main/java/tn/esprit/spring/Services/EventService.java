package tn.esprit.spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.categrorieeventRepo;
import tn.esprit.spring.Repository.eventrepo;
import tn.esprit.spring.entites.Categorieevent;
import tn.esprit.spring.entites.Event;

@Service
public class EventService {
    @Autowired
  private tn.esprit.spring.Repository.eventrepo eventrepo ;
    private tn.esprit.spring.Repository.categrorieeventRepo categrorieeventRepo ;

    // ajouter un evenement et l'affecter a une categorie :

    public Event ajouteretaffecterevent ( Event event , Integer idCategorieEvent) {
        Categorieevent categorieevent = categrorieeventRepo.findById(idCategorieEvent).get();
        event.setCategorieevent(categorieevent);
        return  eventrepo.save(event);

    }

    // affecter un evenement deja exist a une categorie

    public void affecter (Integer idevent , Integer idCategorieEvent) {
        Categorieevent categorieevent = categrorieeventRepo.findById(idCategorieEvent).get();
        Event event = eventrepo.findById(idevent).get();
        event.setCategorieevent(categorieevent);
        eventrepo.save(event) ;
    }
}
