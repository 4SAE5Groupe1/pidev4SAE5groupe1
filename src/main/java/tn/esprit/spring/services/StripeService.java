package tn.esprit.spring.services;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.SubscriptionRepo;

import java.util.HashMap;
import java.util.Map;
@Service
public class StripeService {
    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Value("${stripe.key.secret}")
    private String API_SECET_KEY;

    public StripeService() {

    }



    public String createCharge(String email, String token, int prix) {

        String chargeId = null;
        Subscription s = new Subscription();
        try {
            Stripe.apiKey = API_SECET_KEY;
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("description","Charge for "+email);
            chargeParams.put("currency","usd");
            chargeParams.put("amount",prix);
            chargeParams.put("source",token);
            s.setEmail(email);
            s.setToken(token);
            s.setPrix(prix);
            s.setStatus(true);
            subscriptionRepo.save(s);

            Charge charge = Charge.create(chargeParams);

            chargeId = charge.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chargeId;
    }

}
