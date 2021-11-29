package com.adorsys.stripetest.service;

import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;

public interface PaymentService {
    PaymentIntent initPayment(PaymentIntentCreateParams paymentIntentCreateParams);

    PaymentIntent confirmPayment(String intentId, PaymentIntentConfirmParams paymentIntentConfirmParams);
}
