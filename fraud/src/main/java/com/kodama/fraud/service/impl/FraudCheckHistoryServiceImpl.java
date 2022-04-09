package com.kodama.fraud.service.impl;

import com.kodama.fraud.model.FraudCheckHistory;
import com.kodama.fraud.repository.FraudCheckHistoryRepository;
import com.kodama.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImpl implements FraudCheckHistoryService {

    private FraudCheckHistoryRepository fraudCheckHistoryRepository;
    private Random rd;

    @Override
    public boolean isFraudster(Integer customerId) {
        log.info("+isFraudster(): customerId: {}", customerId);
        boolean isFraudster = rd.nextBoolean();

        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraud(isFraudster)
                        .build()
        );
        log.info("-isFraudster(): customerId: {}, isFraudster: {}", customerId, isFraudster);
        return isFraudster;
    }
}
