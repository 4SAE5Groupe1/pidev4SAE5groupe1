package tn.esprit.spring.services;


import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import tn.esprit.spring.repositories.DislikeRepo;
import tn.esprit.spring.repositories.LikeRepo;
import tn.esprit.spring.repositories.ParticipationEventRepo;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.configuration.MailResponse;
import tn.esprit.spring.configuration.MailmakerConf;
import tn.esprit.spring.configuration.PaypalPaymentIntent;
import tn.esprit.spring.configuration.PaypalPaymentMethod;
import tn.esprit.spring.entites.Event;
import tn.esprit.spring.entites.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.*;


@Service
public class EventService {
    @Autowired
    private Configuration config;

    @Autowired
  private  MailmakerConf mailmakerConf ;

    @Autowired
    private APIContext apiContext;
    @Autowired
    private tn.esprit.spring.repositories.eventrepo eventrepo;
    @Autowired

    private tn.esprit.spring.repositories.categrorieeventRepo categrorieeventRepo;
    @Autowired
    private ParticipationEventRepo participationEventRepo;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender ;
    @Autowired
    private LikeRepo likeRepo ;
    @Autowired
    private DislikeRepo dislikeRepo ;
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


@Transactional
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

                Map<String, Object> model = new HashMap<>();
                model.put("event", event.getName());
                model.put("name", user.getName());
                MailResponse response = new MailResponse();
                MimeMessage message = javaMailSender.createMimeMessage();
                try {
                    // set mediaType
                    MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                            StandardCharsets.UTF_8.name());
                    // add attachment
                    //  helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

                    Template t = config.getTemplate("email-template.ftl");
                    String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

                    helper.setTo(user.getEmail());
                    helper.setText(html, true);
                    helper.setSubject("new mail from " + user.getName());
                    helper.setFrom("testmailingspring@gmail.com");
                    javaMailSender.send(message);

                    response.setMessage("mail send to : " + user.getEmail());
                    response.setStatus(Boolean.TRUE);

                } catch (MessagingException | IOException | TemplateException e) {
                    response.setMessage("Mail Sending failure : " + e.getMessage());
                    response.setStatus(Boolean.FALSE);
                }

            } else
                System.out.println("evenement terminé");
        }
        else {

           // Event event = eventrepo.findById(idevent).get();
            ParticipationEvent participationEvent = new ParticipationEvent();


            User user = userRepository.findById(id).get();
            participationEvent.setEvent(event);
            participationEvent.setUser(user);
            event.setNumberParticipant(event.getNumberParticipant() + 1);


        }
}

    public Payment createPayment(
            Double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException{
        Amount amount = new Amount();
        amount.setCurrency(currency);
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
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
     return   payment.execute(apiContext, paymentExecute) ;

    }






   /* public void exportpdf(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4) ;
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTitre = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitre.setSize(18);
        fontTitre.setColor(Color.BLUE);
        Paragraph paragraph = new Paragraph("Bienvenue" , fontTitre) ;
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        Font fontparagraph = FontFactory.getFont(FontFactory.HELVETICA) ;
        Paragraph paragraph1 = new Paragraph("Name : " + )*/


    //}
    // add  like event and if the user have dislike delete it
    @Transactional
     public void likeEvent(Integer idevent, Integer id){

         Event event = eventrepo.findById(idevent).get();
         User user = userRepository.findById(id).get();


         LikeEvent likeEvent = new LikeEvent() ;
         likeEvent.setEvent(event);
         likeEvent.setUser(user);
             likeRepo.save(likeEvent);
         event.setNumberLike(event.getNumberLike()+1);
        if (dislikeRepo.FindDislikeByUserId(id) != null){
            event.setNumberLike(event.getNumberDislike()-1);
            dislikeRepo.deleteById(dislikeRepo.FindDislikeByUserId(id).getIdDislike());
        }




     }
     // add dislike event and if user have like event delete it
     @Transactional
     public void DislikeEvent (Integer idevent, Integer id){
        Event event = eventrepo.findById(idevent).get();
        User user = userRepository.findById(id).get();
        DislikeEvent dislikeEvent = new DislikeEvent() ;
        dislikeEvent.setEvent(event);
        dislikeEvent.setUser(user);
        dislikeRepo.save(dislikeEvent);
        event.setNumberDislike(event.getNumberDislike()+1);

             if (likeRepo.FindlikeByUserId(id) != null){
                 event.setNumberLike(event.getNumberLike()-1);
                likeRepo.deleteById(likeRepo.FindlikeByUserId(id).getIdLike());
             }
  }


    // number de participation par event
public Long numberparticipation(long idevent){

       return eventrepo.NumberdeParticipationParIdEvent((int) idevent) ;



}
    //  faire un remise de 50% si -1 jour de la debut de l'event et le nembre de participant pas encore max et envoyer un mail a tous les users

    public void remiseEvent( long idevent){
     /*  Long j = numberparticipation(idevent);
        Event event = eventrepo.findById((int)idevent).get();
      long d = event.getNumberParticipantMax();


        if (event.getStartdate().equals(new Date()) && j< d ) {
            event.setPrice(event.getPrice()/2);
            eventrepo.save(event);*/
          //  ParticipationEvent participationEvent = participationEventRepo.findById((int)idevent).get();
            // envoyer un mail pour les autres users qui ne sont pas encore participer
        Event event = eventrepo.findById((int)idevent).get();
            List<User> users = userRepository.findAll();
            List<User > users1 =userRepository.findAll();
            List<ParticipationEvent> list = participationEventRepo.getlistparticipationwithIdEvent((int)idevent) ;
            for ( User u: users) {
                for (ParticipationEvent p : list){

                    if (u.getId() == p.getUser().getId()) {
                        users1.remove(u);
                        //users1.add(u);
                       /* ArrayList<List> L1 = new ArrayList<List>();
                        L1.add(users) ;*/
                    }
                    else {
                        System.out.println("wissss");
                    }
                }
            }
        for (User a: users1) {

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("testmailingspring@gmail.com");
            mailMessage.setTo(a.getEmail());
            mailMessage.setSubject("new mail from " + a.getName());
            mailMessage.setText("MR/M" + a.getName() + " Nous avons fait un remise de 50 %  pour notre evenement " + event.getName() + "qui commence le " + event.getStartdate() + "nous attendons votre participation");
            javaMailSender.send(mailMessage);}



    }



// list des participation a un evenement donné
public List<ParticipationEvent> listparticipationwithIdEvent (long idevent){
   List<ParticipationEvent> list = participationEventRepo.getlistparticipationwithIdEvent((int)idevent) ;
     return list ;
}

    // affichage selon numbre de like , genre ,


// tester le resultat deux boucle for et if :
 // faire la comparaison entre les id de deux tables user.id et user id d'un participation a un evenement donné :

    public String tester (long idevent){
        List<User> users = userRepository.findAll();
        List<ParticipationEvent> list = participationEventRepo.getlistparticipationwithIdEvent((int)idevent) ;
        for ( User user: users)
       {


           for (ParticipationEvent p : list){

                 if (user.getId() != p.getUser().getId()) {
                     System.out.println("oui");

                 }
                 else System.out.println("non");



             }


        }

        return "wiss";
    }

    //find user by event id
    public User findUser (Integer id){
     User user =    userRepository.findById(id).get() ;
     return  user ;

    }


}






