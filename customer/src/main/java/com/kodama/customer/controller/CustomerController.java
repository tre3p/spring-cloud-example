package com.kodama.customer.controller;

import com.kodama.customer.dto.CustomerDto;
import com.kodama.customer.model.Customer;
import com.kodama.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public void newCustomer(@RequestBody CustomerDto customerDto) {
        log.info("+newCustomer(): new customer to register: {}", customerDto);
        Customer customer = customerService.registerNewCustomer(customerDto);
        log.info("-newCustomer(): customer successfully registered: {}", customer);
    }
}
