package com.kodama.customer.service.impl;

import com.kodama.customer.dto.CustomerDto;
import com.kodama.customer.dto.FraudCheckResponse;
import com.kodama.customer.model.Customer;
import com.kodama.customer.repository.CustomerRepository;
import com.kodama.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private RestTemplate restTemplate;

    @Override
    public Customer registerNewCustomer(CustomerDto customerDto) {
        log.info("+registerNewCustomer(): customerDto: {}", customerDto);
        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        customer.setIsFraud(fraudCheckResponse.isFraud());

        log.info("-registerNewCustomer()");
        return customerRepository.save(customer);
    }
}
