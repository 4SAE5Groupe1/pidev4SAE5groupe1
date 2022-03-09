package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tn.esprit.spring.entites.ResponsePayment;
import tn.esprit.spring.services.StripeService;

public class StripeController {




    @Controller
    public class PaymentController {
        @Value("${stripe.key.public}")
        private String API_PUBLIC_KEY;

        private StripeService stripeService;

        public PaymentController(StripeService stripeService) {
            this.stripeService = stripeService;
        }

        @GetMapping("/")
        public String homepage() {
            return "homepage";
        }

        @GetMapping("/charge")
        public String chargePage(Model model) {
            model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
            return "charge";
        }


        @PostMapping("/create-charge")
        public @ResponseBody
        ResponsePayment createCharge(String email, String token) {

            if (token == null) {
                return new ResponsePayment(false, "Stripe payment token is missing. please try again later.");
            }

            String chargeId = stripeService.createCharge(email, token, 999);// 9.99 usd

            if (chargeId == null) {
                return new ResponsePayment(false, "An error accurred while trying to charge.");
            }

            // You may want to store charge id along with order information

            return new ResponsePayment(true, "Success your charge id is " + chargeId);
        }
    }
}
