package com.kodama.customer.service.impl;

import com.kodama.customer.dto.CustomerDto;
import com.kodama.customer.model.Customer;
import com.kodama.customer.repository.CustomerRepository;
import com.kodama.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer registerNewCustomer(CustomerDto customerDto) {
        log.info("+registerNewCustomer(): customerDto: {}", customerDto);
        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        log.info("-registerNewCustomer()");
        return customerRepository.save(customer);
    }
}
