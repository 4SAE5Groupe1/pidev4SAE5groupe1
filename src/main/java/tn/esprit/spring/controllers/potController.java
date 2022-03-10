/*
package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Donation;
import tn.esprit.spring.entites.pot;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class potController {
    @Autowired
    tn.esprit.spring.services.servicepot servicepot ;

    @PostMapping("/addpot")
    public ResponseEntity<pot> addpot(@RequestBody pot pot){
        pot result =servicepot.addpot(pot);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @GetMapping("/listDonationByIdPot/{idpot}")
    public List<Donation> listDonationByIdPot(Integer idpot){
        return servicepot.listdonationbyidpot(idpot) ;
    }
}
*/
