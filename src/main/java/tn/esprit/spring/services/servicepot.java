/*
package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entites.Donation;
import tn.esprit.spring.entites.pot;
import tn.esprit.spring.repositories.repoPot;

import java.util.List;

@Service

public class servicepot {
    @Autowired
    private tn.esprit.spring.repositories.donationRepo donationRepo ;
    @Autowired
    // ajouter pot
    private repoPot repopot ;

    public pot addpot(pot pot){
        return repopot.save(pot);
    }
    // add donation

    //1 get donation par id pot
    public List<Donation> listdonationbyidpot(Integer idpot){
        List <Donation > donations = donationRepo.FinddonationByIdPot(idpot);
        return  donations ;

    }


    public int sommedonation(Integer idpot){
        List <Donation > donations = donationRepo.FinddonationByIdPot(idpot);
        int sum = 0;
        for (Donation d :donations){

        }
        return  sum ;
    }
     public void addDonation(Donation donation , Integer idpot){
        pot pot =repopot.findById(idpot).get();
        if (pot.getTotalAmount()< sum){
            donationRepo.save(donation);
        }
        else{
            pot.get
        }


     }




}
*/
