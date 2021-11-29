package com.adorsys.stripetest.controller;

import com.adorsys.stripetest.service.SubscriptionService;
import com.stripe.model.Customer;
import com.stripe.model.Price;
import com.stripe.param.PriceListParams;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody SessionCreateParams sessionCreateParams){
        subscriptionService.createSubscription(sessionCreateParams);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Customer> getAll(@RequestBody PriceListParams priceListParams){
        return new ResponseEntity(subscriptionService.find(priceListParams), HttpStatus.OK);
    }
    @RequestMapping(value = "/{priceId}}", method = RequestMethod.GET)
    public ResponseEntity<Price> getById(@PathVariable String priceId){
        return new ResponseEntity(subscriptionService.find(priceId), HttpStatus.OK);
    }
}
