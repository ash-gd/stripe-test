package com.adorsys.stripetest.config;

import com.stripe.net.RequestOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Bean
    RequestOptions requestOptions(){
        return RequestOptions.builder()
                .setApiKey("sk_test_51JUSihCZj8kO11oWHp8EBhQaTgYRsgoiFLNExp8lyw365xFNcWmBqRkIdEJ0ynbuJgtRMzLqwhBIm4XaklHVrWRo00bcJIIixT")
                .build();
    }
}
