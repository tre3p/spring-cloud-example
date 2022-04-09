package com.kodama.fraud.controller;

import com.kodama.clients.dto.FraudCheckResponse;
import com.kodama.fraud.service.impl.FraudCheckHistoryServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckController {

    private final FraudCheckHistoryServiceImpl fraudCheckHistoryService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerId) {
        log.info("+isFraud(): customerId: {}", customerId);
        boolean isCustomerFraudulent = fraudCheckHistoryService.isFraudster(customerId);
        log.info("-isFraud(): isCustomerFraudulent: {}", isCustomerFraudulent);
        return new FraudCheckResponse(isCustomerFraudulent);
    }
}
