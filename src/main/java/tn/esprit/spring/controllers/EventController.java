package tn.esprit.spring.controllers;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.configuration.PaypalPaymentIntent;
import tn.esprit.spring.configuration.PaypalPaymentMethod;
import tn.esprit.spring.configuration.URLUtils;
import tn.esprit.spring.entites.*;
import tn.esprit.spring.repositories.ParticipationEventRepo;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.EventService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/api/test")
public class EventController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";
    @Autowired
    ParticipationEventRepo participationEventRepo ;
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
    @GetMapping("/listdesEve")
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
            String cancelUrl = URLUtils.getBaseURl(request) + "/api/test/" + PAYPAL_CANCEL_URL;
            String successUrl = URLUtils.getBaseURl(request) + "/api/test/" + PAYPAL_SUCCESS_URL;

            try {
                Payment payment = eventService.createPayment(
                        d,
                        "USD",
                        PaypalPaymentMethod.paypal,
                        PaypalPaymentIntent.sale,

                        event.getIdevent(),
                        cancelUrl,
                        successUrl);
                for(Links links : payment.getLinks()){
                    if(links.getRel().equals("approval_url")){
                  return "redirect:" + links.getHref();
                    }


                }

                ParticipationEvent participationEvent = new ParticipationEvent();


                User user = userRepository.findById(id).get();
                participationEvent.setEvent(event);
                participationEvent.setUser(user);
                event.setNumberParticipant(event.getNumberParticipant() + 1);
                participationEventRepo.save(participationEvent);


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


                System.out.println(payment.toJSON());
                System.out.println("______________"+payment.getTransactions().get(0).getDescription());
              Event event = eventrepo.getById(Integer.valueOf(payment.getTransactions().get(0).getDescription()));
              ParticipationEvent participationEvent = new ParticipationEvent() ;
              participationEvent.setEvent(event);
               // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
               /* User user =userRepository.findById()

                    participationEvent.setUser(user);
                participationEventRepo.save(participationEvent);
*/



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

    // pourcentage de participation pour chaque evenement par raport nembre de participation maximale :
    @GetMapping("/pourcentageparticipation/{idevent}")
    public  String pourcentageparticipation (@PathVariable int idevent){


        return eventService.pourcentageparticipation(idevent);

    }

    // filtrer les evenement par nom de categorie :

    @GetMapping("/geteventByCategorie/{name}")
    public  List<Event> geteventByCategorie (@PathVariable String name){


        return eventService.FiltrerEventBycategorieevent(name);

    }
// filtrer les evenemnt par date de debut :
@GetMapping("/FiltrerEventByStartdate/{d}")
@ResponseBody
public List<Event> FiltrerEventByStartdate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d){
    return eventService.FiltrerEventByStartdate( d);
}

//affichage par nembre de like
@GetMapping("/FiltrerEventBynembrelike")
@ResponseBody
public List<Event> getlistedesEvenementmaxreact (){
    return eventService.listedesEvenementmaxreact();
}






}














