package com.kodama.fraud.controller;

import com.kodama.fraud.dto.FraudCheckResponse;
import com.kodama.fraud.service.impl.FraudCheckHistoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckController {

    private final FraudCheckHistoryServiceImpl fraudCheckHistoryService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerId) {
        boolean isCustomerFraudulent = fraudCheckHistoryService.isFraudster(customerId);
        return new FraudCheckResponse(isCustomerFraudulent);
    }
}
