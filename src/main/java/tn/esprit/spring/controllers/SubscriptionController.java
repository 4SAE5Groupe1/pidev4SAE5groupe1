package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.services.SubscriptionDAO;
import tn.esprit.spring.services.SubscriptionService;

import java.util.List;

@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    // http://localhost:8089/SpringMVC/servlet/getAllSubscriptions
    @GetMapping("/getAllSubscriptions")
    @ResponseBody
    public List<Subscription> getAllSubscriptions(){
        List<Subscription> subscriptionList = (List<Subscription>) subscriptionService.getAllSubscriptions();
        return subscriptionList;
    }

    // http://localhost:8089/SpringMVC/servlet/addSubscription
    @PostMapping("/addSubscription")
    @ResponseBody
    public Subscription addSubscription(@RequestBody Subscription s){
        Subscription subscription = subscriptionService.addSubscription(s);
        return subscription;
    }

    // http://localhost:8089/SpringMVC/servlet/getSubscription
    @GetMapping("/getSubscription/{subscriptionId}")
    @ResponseBody
    public Subscription getSubscription(@PathVariable("subscriptionId") int subscriptionId){
        Subscription subscription = subscriptionService.getSubscription(subscriptionId);
        return subscription;
    }

    // http://localhost:8089/SpringMVC/servlet/updateSubscription
    @PutMapping("/updateSubscription")
    @ResponseBody
    public Subscription updateSubscription(@RequestBody Subscription subscription){
        return subscriptionService.updateSubscription(subscription);
    }

    // http://localhost:8089/SpringMVC/servlet/deleteSubscription
    @DeleteMapping("/deleteSubscription/{subscriptionId}")
    @ResponseBody
    public void deleteSubscription(@PathVariable("subscriptionId") int subscriptionId){
        subscriptionService.deleteSubscription(subscriptionId);
    }
}
