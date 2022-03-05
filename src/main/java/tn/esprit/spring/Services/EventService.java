/*
package tn.esprit.spring.Services;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.ParticipationEventRepo;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.configuration.PaypalPaymentIntent;
import tn.esprit.spring.configuration.PaypalPaymentMethod;
import tn.esprit.spring.entites.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class EventService {
    @Autowired
    private APIContext apiContext;
    @Autowired
    private tn.esprit.spring.Repository.eventrepo eventrepo;
    @Autowired

    private tn.esprit.spring.Repository.categrorieeventRepo categrorieeventRepo;
    @Autowired
    private ParticipationEventRepo participationEventRepo;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender ;
    // ajouter un evenement et l'affecter a une categorie :

    public Event ajouteretaffecterevent(Event event, Integer idCategorieEvent) {
        Categorieevent categorieevent = categrorieeventRepo.findById(idCategorieEvent).orElse(null);
        event.setCategorieevent(categorieevent);
        return eventrepo.save(event);

    }

    // affecter un evenement deja exist a une categorie

    public void affecter(Integer idevent, Integer idCategorieEvent) {


        Categorieevent categorieevent = categrorieeventRepo.findById(idCategorieEvent).orElse(null);

        Event event = eventrepo.findById(idevent).orElse(null);
        event.setCategorieevent(categorieevent);
        eventrepo.save(event);
    }

    //afficher les events :
    public List<Event> ListofEvents() {
        return eventrepo.findAll();
    }

    //recherche evenement par id :
    public Event findEventById(Integer id) {
        return eventrepo.findById(id).get();

    }
//participer a une evenement :
    */
/*public ParticipationEvent participerevent ( Integer idevent , Integer id) {
        Event event = eventrepo.findById(idevent).get();
        for ( i =0 ; i< event.getNumberParticipant() ; i++) {
            System.out.println(i);
        ParticipationEvent participationEvent = new ParticipationEvent();



        User user = userRepository.findById(id).get();
        participationEvent.setEvent(event);
        participationEvent.setUser(user);
participationEventRepo.save(participationEvent); }
        return null;}*//*


    public void participerevent(Integer idevent, Integer id) {
        Event event = eventrepo.findById(idevent).get();
        if (event.getTypeevent() == TypeEvent.Gratuite) {
            System.out.println(event.getNumberParticipantMax());
            if (event.getNumberParticipant() < event.getNumberParticipantMax() && event.getEndDate().after(new Date())) {
                ParticipationEvent participationEvent = new ParticipationEvent();


                User user = userRepository.findById(id).get();
                participationEvent.setEvent(event);
                participationEvent.setUser(user);
                event.setNumberParticipant(event.getNumberParticipant() + 1);

                participationEventRepo.save(participationEvent);
                // envoyer un email a un participant lorsque il participe a un evenement gratuit
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom("testmailingspring@gmail.com");
                mailMessage.setTo(user.getEmail());
                mailMessage.setSubject("new mail from " + user.getName());
                mailMessage.setText("MR/M" + user.getName()+"Bienvenue a notre evenement "+event.getName() +"qui commence le "+event.getStartdate());
                javaMailSender.send(mailMessage);
                System.out.println("mail envoyé");

            } else
                System.out.println("evenement terminé");
        }
        else
            System.out.println("l'evenement est payante vous devez achter un ticket");
    }

    public Payment createPayment(
            double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException{
        Amount amount = new Amount();
        amount.setCurrency(currency);
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
      //  amount.setTotal(String.format("%.2f", total));
        amount.setTotal(String.format("%.3f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());

        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }


    public void participationPayante (Integer idevent, Integer id ){
        Event event = eventrepo.findById(idevent).get();
        User user = userRepository.findById(id).get();

        if (event.getEtatPayement().equals(EtatPayement.Approved)) {
            ParticipationEvent participationEvent = new ParticipationEvent();
            participationEvent.setEvent(event);
            participationEvent.setUser(user);
            event.setNumberParticipant(event.getNumberParticipant() + 1);

            participationEventRepo.save(participationEvent);

        }


    }


}





*/
