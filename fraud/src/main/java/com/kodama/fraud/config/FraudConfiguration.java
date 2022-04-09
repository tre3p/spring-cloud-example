package com.kodama.fraud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class FraudConfiguration {
    @Bean
    Random random() {
        return new Random();
    }
}
