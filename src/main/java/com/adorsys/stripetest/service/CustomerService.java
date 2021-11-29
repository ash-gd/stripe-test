package com.adorsys.stripetest.service;

import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;

public interface CustomerService {
    Customer create(CustomerCreateParams customerCreateParams);

    Customer find(String customerId);
}
