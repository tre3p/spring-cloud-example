package com.kodama.notification.service.impl;

import com.kodama.clients.dto.NotificationRequest;
import com.kodama.notification.model.Notification;
import com.kodama.notification.repository.NotificationRepository;
import com.kodama.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private static final String WELCOME_TEMPLATE = "Dear, %s, you have been successfully registered!";

    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.customerId())
                        .toCustomerEmail(notificationRequest.customerEmail())
                        .toCustomerName(notificationRequest.customerName())
                        .message(String.format(WELCOME_TEMPLATE, notificationRequest.customerName()))
                        .sender("kodama@dev.com")
                        .build()
        );
    }
}
