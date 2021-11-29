package com.adorsys.stripetest.service.impl;

import com.adorsys.stripetest.service.SubscriptionService;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.PriceCollection;
import com.stripe.model.checkout.Session;
import com.stripe.param.PriceListParams;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public Price find(String priceId) {
        try {
            return Price.retrieve(priceId);
        } catch (StripeException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public PriceCollection find(PriceListParams priceListParams) {
        try {
            return Price.list(priceListParams);
        } catch (StripeException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void createSubscription(SessionCreateParams sessionCreateParams) {
        try {
            Session.create(sessionCreateParams);
        } catch (StripeException e) {
            log.error(e.getMessage());
        }
    }
}
