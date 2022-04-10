package com.kodama.notification.controller;

import com.kodama.clients.dto.NotificationRequest;
import com.kodama.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("+sendNotification(): notificationRequest: {}", notificationRequest);
        notificationService.send(notificationRequest);
        log.info("-sendNotification()");
    }
}
