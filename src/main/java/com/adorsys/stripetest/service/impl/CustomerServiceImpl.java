package com.adorsys.stripetest.service.impl;

import com.adorsys.stripetest.service.CustomerService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer create(CustomerCreateParams customerCreateParams) {
        try {
            return Customer.create(customerCreateParams);
        } catch (StripeException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Customer find(String customerId) {
        try {
            return Customer.retrieve(customerId);
        } catch (StripeException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
