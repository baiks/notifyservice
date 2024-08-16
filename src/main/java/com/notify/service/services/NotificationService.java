package com.notify.service.services;

import com.notify.service.dtos.NotificationDto;

public interface NotificationService {
    void process(NotificationDto notificationDto);
}