/*
package tn.esprit.spring.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Services.EventService;
import tn.esprit.spring.configuration.PaypalPaymentIntent;
import tn.esprit.spring.configuration.PaypalPaymentMethod;
import tn.esprit.spring.entites.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private tn.esprit.spring.Repository.eventrepo eventrepo ;
    public static final String SUCCESS_URL = "user/success";
    public static final String CANCEL_URL = "pay/cancel";
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
    public String participeEvent( @PathVariable("idevent") Integer idevent , @PathVariable ("id") Integer id ) {

        Event event = eventService.findEventById(idevent);
        double d = event.getPrice();
        if (event.getTypeevent().equals(TypeEvent.Gratuite)) {
            eventService.participerevent(idevent, id);
            //  return new ResponseEntity<>(HttpStatus.OK);
        } else {

                try {
                    Payment payment = eventService.createPayment(
                            1.00 ,
                            "USD",
                            PaypalPaymentMethod.paypal,
                            PaypalPaymentIntent.sale,
                            "payment description",
                            "http://localhost:8080/" + CANCEL_URL,
                            "http://localhost:8080/" + SUCCESS_URL);
                    for(Links links : payment.getLinks()){
                        if(links.getRel().equals("approval_url")){
                            return "redirect:" + links.getHref();
                        }
                    }
                } catch (PayPalRESTException e) {
                    e.printStackTrace();
                }
                return "redirect:/";

        }

        return "redirect:/";
    }





    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping(value = SUCCESS_URL)

    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,@RequestParam("idevent") Integer idevent , @RequestParam ("id") Integer id) {
        try {
            Payment payment = eventService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {


                System.out.println("-----------payment ------------------"
                        +payment);
                Event event =eventService.findEventById(idevent) ;
                event.setEtatPayement(EtatPayement.Approved);
                eventrepo.save(event);

                eventService.participationPayante(idevent,id);
              //  System.out.println("success");

                return "success";

            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

}
*/
