package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Badge;
import tn.esprit.spring.services.BadgeService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class BadgeController {
    @Autowired
    BadgeService badgeService;
    //@Autowired
    //QRCodeGenerator qrCodeGenerator;
    //http:localhost:8080/api/test/getAllBadges
    @GetMapping("/getAllBadges")
    @ResponseBody
    public List<Badge> getAllBadges (){
        List<Badge> badges = badgeService.getAllBadges();
        return badges;
    }

    //http:localhost:8080/api/test/addBadge
    @PostMapping("/addBadge")
    @ResponseBody
    public Badge addBadge(@RequestBody Badge b) {
        return badgeService.addBadge(b);
    }

    //http:localhost:8080/api/test/updateBadge
    @PutMapping("/updateBadge")
    @ResponseBody
    public Badge updateBadge(@RequestBody Badge b){
        return badgeService.updateBadge(b);
    }

    //http:localhost:8080/api/test/deleteBadge
    @DeleteMapping("/deleteBadge/{badgeId}")
    @ResponseBody
    public void deleteBadge(@PathVariable("badgeId") int badgeId){
        badgeService.deleteBadge(badgeId);
    }

    //http:localhost:8080/api/test/getBadge
    @GetMapping("/getBadge/{badgeId}")
    public Badge getBadge(@PathVariable("badgeId") int badgeId){
        Badge badge = badgeService.getBadge(badgeId);
        return badge;
    }

    //http:localhost:8080/api/test/ajouterEtaffecterListeBadge
    @PostMapping("/ajouterEtaffecterListeBadge/{idUser}")
    public void ajouterEtaffecterListeBadge(@RequestBody Badge badge, @PathVariable("idUser") int idUser){
        badgeService.ajouterEtaffecterListeBadge(badge,idUser);
    }

}
