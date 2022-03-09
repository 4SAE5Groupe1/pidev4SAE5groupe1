package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entites.Categorieevent;

import java.util.List;

@Service
public class categorieEventService {
@Autowired
    private tn.esprit.spring.repositories.categrorieeventRepo categrorieeventRepo ;
// ajouter une categorie :
 public Categorieevent saveOrUpdateCategrorie (Categorieevent categorieevent) {
     categrorieeventRepo.save(categorieevent) ;
     return  categorieevent ;
 }

  // supprimer une categorie :
     public void deletecategorie (Integer id) {
     categrorieeventRepo.deleteById(id);

     }

     // rechercher une categorie par id :
     public Categorieevent getcategorieById(Integer id) {
      return categrorieeventRepo.findById(id).get();
     }

     //liste des categorie :
    public List<Categorieevent> getAllCategorie () {
     return categrorieeventRepo.findAll() ;
 }

 // modifier une categorie :
/* public Categorieevent updateCategorie ( Integer id , Categorieevent categorieevent)  {
  Categorieevent existingCategorie = getcategorieById(id) ;
    // Categorieevent existingCategorie = categrorieeventRepo.findById(categorieevent.getIdCategorieEvent()).get() ;
    existingCategorie.setName(categorieevent.getName());
    existingCategorie.setDescription(categorieevent.getDescription());
     existingCategorie.setIdCategorieEvent(categorieevent.getIdCategorieEvent());

     return categrorieeventRepo.save(existingCategorie);
 }*/

}
