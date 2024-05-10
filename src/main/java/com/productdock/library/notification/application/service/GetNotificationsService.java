package com.productdock.library.notification.application.service;

import com.productdock.library.notification.application.port.in.GetNotificationsQuery;
import com.productdock.library.notification.application.port.out.persistence.NotificationPersistenceOutPort;
import com.productdock.library.notification.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GetNotificationsService implements GetNotificationsQuery {

    private NotificationPersistenceOutPort notificationPersistenceOutPort;
    @Override
    public List<Notification> getNotifications(String userId) {
        return notificationPersistenceOutPort.getAllByUserId(userId);
    }

    @Override
    public int getUnreadNotificationsCount(String userId) {
        return notificationPersistenceOutPort.getUnreadByUserId(userId).size();
    }
}
