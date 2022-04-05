package com.kodama.fraud.service.impl;

import com.kodama.fraud.model.FraudCheckHistory;
import com.kodama.fraud.repository.FraudCheckHistoryRepository;
import com.kodama.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImpl implements FraudCheckHistoryService {

    private FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudster(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .build()
        );
        return false;
    }
}
