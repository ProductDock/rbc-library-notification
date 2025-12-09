package com.productdock.library.notification.application.service;

import com.productdock.library.notification.application.port.in.ReadNotificationsUseCase;
import com.productdock.library.notification.application.port.out.persistence.NotificationPersistenceOutPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReadNotificationsService implements ReadNotificationsUseCase {

    private NotificationPersistenceOutPort notificationPersistenceOutPort;

    @Override
    public void markAsReadNotifications(String userId) {
        var notifications = notificationPersistenceOutPort.getUnreadByUserId(userId);
        notifications.forEach(notification -> notification.setRead(true));
        notificationPersistenceOutPort.saveAll(notifications);
    }
}
