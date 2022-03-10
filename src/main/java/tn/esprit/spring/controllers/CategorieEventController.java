package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Categorieevent;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class CategorieEventController {
    @Autowired
    tn.esprit.spring.services.categorieEventService categorieEventService ;

// ajouter categorie
@PostMapping("/addCategorieEvent")
public ResponseEntity<Categorieevent> ajouterCatergorieEvent(@RequestBody Categorieevent categorieevent){
    Categorieevent result =categorieEventService.saveOrUpdateCategrorie(categorieevent);
    return new ResponseEntity<>(result, HttpStatus.CREATED);

}

// supprimer Categorie :
@DeleteMapping("/deleteCategorieEvent/{id}")
public ResponseEntity<Categorieevent> deleteCategorieevent(@PathVariable Integer id){
    categorieEventService.deletecategorie(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
// liste des categories :
@GetMapping("/listdesCategoriesEvent")
public ResponseEntity<List<Categorieevent>> listdesCategorieevent(){
    List<Categorieevent> result = categorieEventService.getAllCategorie();
    return new ResponseEntity<>(result , HttpStatus.OK);
}

//modifier categorie :
@PutMapping("/modifiercategorieevent")
public ResponseEntity<Categorieevent> updatecategorieevent(Categorieevent categorieevent){
    System.out.println(categorieevent);
    Categorieevent result = categorieEventService.saveOrUpdateCategrorie(categorieevent);
    return new ResponseEntity<>(result,HttpStatus.OK);
}

// recherche de categorie apr id :
@GetMapping("/listdescategories/{id}")
public ResponseEntity<Categorieevent> getcategorieByid(@PathVariable Integer id){

    Categorieevent result = categorieEventService.getcategorieById(id);
    return new ResponseEntity<>(result , HttpStatus.OK);
}
}
