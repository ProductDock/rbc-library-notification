package com.productdock.library.notification.application.service;

import com.productdock.library.notification.application.port.in.AddNotificationUseCase;
import com.productdock.library.notification.application.port.out.persistence.NotificationPersistenceOutPort;
import com.productdock.library.notification.domain.Notification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddNotificationService implements AddNotificationUseCase {

    private NotificationPersistenceOutPort notificationPersistenceOutPort;
    @Override
    public void saveNotification(Notification notification) {
        notificationPersistenceOutPort.save(notification);
    }
}
