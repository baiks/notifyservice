package com.notify.service.kafka;

import com.notify.service.dtos.NotificationDto;
import com.notify.service.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Consumer {
    private final NotificationService notificationService;

    @KafkaListener(topics = "notification-topic")
    public void listen(NotificationDto notificationDto) {
        notificationService.process(notificationDto);
    }
}