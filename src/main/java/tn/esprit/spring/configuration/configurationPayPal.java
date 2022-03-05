package tn.esprit.spring.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.api.payments.PaymentHistory;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration

public class configurationPayPal {

    @Value("${paypal.client.id}")
 //   @Value("AYVg_QF_4R5SQvNHP8TV7NoyUbUOmDRrOvs9ozOiilMlYpf7Qp17iFp2HG7TaTbm1e-34znqFZbRr8ZW")
    private String clientId;
    @Value("${paypal.client.secret}")
  //  @Value("EE52GWTNz6TL7EEuakaePDzrAUWz6Z9-xOc3iPnpEaa1tc0IyrYN_sH_puXaJim8GLVAuZEtZzzCGO5U")
    private String clientSecret;
    @Value("${paypal.mode}")
    private String mode;

    @Bean
    public Map<String, String> paypalSdkConfig() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("mode", mode);
        return configMap;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;
    }
}
