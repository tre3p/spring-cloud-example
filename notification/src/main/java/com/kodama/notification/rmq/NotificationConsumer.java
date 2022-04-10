package com.kodama.notification.rmq;

import com.kodama.clients.dto.NotificationRequest;
import com.kodama.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("+consumer(): notificationRequest: {}", notificationRequest);
        notificationService.send(notificationRequest);
        log.info("-consumer()");
    }
}
