package com.adorsys.stripetest.controller;

import com.adorsys.stripetest.service.PaymentService;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ResponseEntity<PaymentIntent> initIntent(@RequestBody PaymentIntentCreateParams paymentIntentCreateParams){
        return new ResponseEntity(paymentService.initPayment(paymentIntentCreateParams), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/confirm/{intentId}", method = RequestMethod.POST)
    public ResponseEntity<PaymentIntent> confirmIntent(@PathVariable String intentId,
                                                       @RequestBody PaymentIntentConfirmParams paymentIntentConfirmParams){
        return new ResponseEntity(paymentService.confirmPayment(intentId, paymentIntentConfirmParams), HttpStatus.OK);
    }
}
