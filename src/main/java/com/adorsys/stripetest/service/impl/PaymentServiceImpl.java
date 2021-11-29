package com.adorsys.stripetest.service.impl;

import com.adorsys.stripetest.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentIntent initPayment(PaymentIntentCreateParams paymentIntentCreateParams) {
        try {
            return PaymentIntent.create(paymentIntentCreateParams);
        } catch (StripeException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public PaymentIntent confirmPayment(String intentId, PaymentIntentConfirmParams paymentIntentConfirmParams) {
        try {
            PaymentIntent paymentIntent = PaymentIntent.retrieve(intentId);
            return paymentIntent.confirm(paymentIntentConfirmParams);
        } catch (StripeException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
