package com.kodama.notification.service;

import com.kodama.clients.dto.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
