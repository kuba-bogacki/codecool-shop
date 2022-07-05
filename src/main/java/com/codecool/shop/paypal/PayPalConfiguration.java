package com.codecool.shop.paypal;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class PayPalConfiguration {

    private String clientId;
    private String clientSecret;
    private String mode;

    @Autowired
    public PayPalConfiguration(
            @Value("${paypal.client.id:}") String clientId,
            @Value("${paypal.secret.id:}") String clientSecret,
            @Value("${paypal.mode:}") String mode) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.mode = mode;
    }

    @Bean
    public Map<String, String> payPalSdkConfiguration() {
        Map<String, String> payPalConfigurationMap = new HashMap<>();
        payPalConfigurationMap.put("mode", mode);
        return payPalConfigurationMap;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, payPalSdkConfiguration());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext apiContext = new APIContext(oAuthTokenCredential().getAccessToken());
        apiContext.setConfigurationMap(payPalSdkConfiguration());
        return apiContext;
    }
}
