package com.adorsys.stripetest.controller;

import com.adorsys.stripetest.service.CustomerService;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreateParams customerCreateParams){
        return new ResponseEntity(customerService.create(customerCreateParams), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/{customerId}}", method = RequestMethod.GET)
    public ResponseEntity<Customer> createCustomer(@PathVariable String customerId){
        return new ResponseEntity(customerService.find(customerId), HttpStatus.OK);
    }
}
