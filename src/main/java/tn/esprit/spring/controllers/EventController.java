package tn.esprit.spring.controllers;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.EventService;
import tn.esprit.spring.configuration.PaypalPaymentIntent;
import tn.esprit.spring.configuration.PaypalPaymentMethod;
import tn.esprit.spring.configuration.URLUtils;
import tn.esprit.spring.entites.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class EventController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private tn.esprit.spring.repositories.eventrepo eventrepo ;

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
   // @RequestMapping(method = RequestMethod.POST, value = "Participer/{idevent}/{id}")
   @PostMapping ("/Participer/{idevent}/{id}")
    public String participeEvent(HttpServletRequest request , @PathVariable("idevent") Integer idevent , @PathVariable ("id") Integer id ) {

        Event event = eventService.findEventById(idevent);
        double d = event.getPrice();
        if (event.getTypeevent().equals(TypeEvent.Gratuite)) {
            eventService.participerevent(idevent, id);
            //  return new ResponseEntity<>(HttpStatus.OK);
        } else {
            String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
            String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;

            try {
                Payment payment = eventService.createPayment(
                        4.00,
                        "USD",
                        PaypalPaymentMethod.paypal,
                        PaypalPaymentIntent.sale,
                        "payment description",
                        cancelUrl,
                        successUrl);
                for(Links links : payment.getLinks()){
                    if(links.getRel().equals("approval_url")){
                  return "redirect:" + links.getHref();
                    }


                }


            } catch (PayPalRESTException e) {
                log.error(e.getMessage());
            }
            return "redirect:/";

        }


        return "participé";
    }




    @GetMapping(PAYPAL_CANCEL_URL)

    public String cancelPay(){
        return "cancel";
    }
@GetMapping(PAYPAL_SUCCESS_URL)


    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {



            Payment payment = eventService.executePayment(paymentId, payerId);

            if(payment.getState().equals("approved")) {

                System.out.println("______________"+payment.getTransactions().get(0).getDescription());
                System.out.println(payment.toJSON());


                return  "success" ;

            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return  null ;
    }
    // ajouter like
    @PostMapping("/addlike/{idevent}/{id}")
    public ResponseEntity<LikeEvent> ajouterLike(@PathVariable("idevent") Integer idevent , @PathVariable ("id") Integer id  ){
        eventService.likeEvent(idevent,id);
        return new ResponseEntity<>( HttpStatus.CREATED);

    }
    //ajouter dislike
    @PostMapping("/adddislike/{idevent}/{id}")
    public ResponseEntity<DislikeEvent> ajouterdisLike(@PathVariable("idevent") Integer idevent , @PathVariable ("id") Integer id  ){
        eventService.DislikeEvent(idevent,id);
        return new ResponseEntity<>( HttpStatus.CREATED);

    }
    // tester number des participation par id event
    @GetMapping("/numberdeparticipation/{id}")
    public Long numberparticipation(@PathVariable Long id){

        return   eventService.numberparticipation(id);
      //  return new ResponseEntity<>(result , HttpStatus.OK);
    }
    // liste des participation par evenement :
    @GetMapping("/Listeparticipation/{idevent}")
    public  List<ParticipationEvent> Listeparticipation(@PathVariable Long idevent){


        List<ParticipationEvent> result = eventService.listparticipationwithIdEvent(idevent);
        return result;
    }
    //test
    @GetMapping("/iduser=iduserparticipe/{idevent}")
    public  String tester (@PathVariable Long idevent){


       return eventService.tester(idevent);

    }
// remise d'un event
    @PostMapping("/addremise/{idevent}")
    public ResponseEntity<Event> addremise ( @PathVariable Integer idevent){
        eventService.remiseEvent( idevent);
        return new ResponseEntity<>( HttpStatus.CREATED);

    }









}
