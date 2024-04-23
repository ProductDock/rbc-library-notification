package com.productdock.library.notification.application.service;

import com.productdock.library.notification.application.port.out.persistence.NotificationPersistenceOutPort;
import com.productdock.library.notification.domain.Notification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.productdock.library.notification.data.provider.domain.NotificationMother.notification;

@ExtendWith(MockitoExtension.class)
public class ReadNotificationServiceShould {

    private static final String USER_ID = "1";
    private static final Notification NOTIFICATION = notification();

    @InjectMocks
    private ReadNotificationsService readNotificationsService;
    @Mock
    private NotificationPersistenceOutPort notificationPersistenceOutPort;

    @Test
    void markNotificationAsRead(){
        var notifications = new ArrayList<Notification>();
        notifications.add(NOTIFICATION);

        readNotificationsService.markAsReadNotifications(USER_ID);

        notificationPersistenceOutPort.saveAll(notifications);
    }
}
