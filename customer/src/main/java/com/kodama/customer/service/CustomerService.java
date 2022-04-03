package com.kodama.customer.service;

import com.kodama.customer.dto.CustomerDto;
import com.kodama.customer.model.Customer;

public interface CustomerService {
    Customer registerNewCustomer(CustomerDto customerDto);
}
