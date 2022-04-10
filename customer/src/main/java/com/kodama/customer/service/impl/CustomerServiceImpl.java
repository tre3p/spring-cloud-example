package com.kodama.customer.service.impl;

import com.kodama.clients.dto.FraudCheckResponse;
import com.kodama.clients.dto.NotificationRequest;
import com.kodama.clients.fraud.FraudClient;
import com.kodama.clients.notification.NotificationClient;
import com.kodama.customer.dto.CustomerDto;
import com.kodama.customer.exception.FraudException;
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

    private static final String CUSTOMER_NAME_FORMATTER = "%s %s";
    private static final String FRAUD_CUSTOMER_MESSAGE_FORMATTER = """
            Dear %s %s, we are so sorry, but we can't register your account, because it's marked like fraud.
            """;

    private CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    @Override
    public Customer registerNewCustomer(CustomerDto customerDto) {
        log.info("+registerNewCustomer(): customerDto: {}", customerDto);
        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraud(customer.getId());

        if (!fraudCheckResponse.isFraud()) {
            notificationClient.sendNotification(
                    new NotificationRequest(
                            customer.getId(),
                            String.format(CUSTOMER_NAME_FORMATTER, customer.getFirstName(), customer.getLastName()),
                            customer.getEmail()
                    )
            );
            log.info("-registerNewCustomer(): customer: {}", customer);
            return customerRepository.save(customer);
        }

        customerRepository.deleteById(customer.getId());
        log.info("-registerNewCustomer(): can't register customer with ID: {}, because it's fraud", customer.getId());
        throw new FraudException(
                        String.format(FRAUD_CUSTOMER_MESSAGE_FORMATTER,
                        customer.getFirstName(),
                        customer.getLastName()));
    }
}
