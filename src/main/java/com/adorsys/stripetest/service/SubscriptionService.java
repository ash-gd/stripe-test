package com.adorsys.stripetest.service;

import com.stripe.model.Price;
import com.stripe.model.PriceCollection;
import com.stripe.param.PriceListParams;
import com.stripe.param.checkout.SessionCreateParams;

public interface SubscriptionService {
    Price find(String priceId);

    PriceCollection find(PriceListParams priceListParams);

    void createSubscription(SessionCreateParams sessionCreateParams);
}
