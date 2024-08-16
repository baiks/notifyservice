package com.notify.service.impl;

import com.google.gson.Gson;
import com.notify.service.dtos.NotificationDto;
import com.notify.service.services.HttpCallsService;
import com.notify.service.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final HttpCallsService httpCallsService;
    @Value("${sms_url}")
    private String smsUrl;

    public void process(NotificationDto notificationDto) {
        String request = new Gson().toJson(NotificationDto.class);
        HttpResponse httpResponse = httpCallsService.post(request, smsUrl);
        log.info("Notification response: {}",httpResponse.getEntity());
    }
}