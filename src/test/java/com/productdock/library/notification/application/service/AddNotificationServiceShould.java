package com.productdock.library.notification.application.service;

import com.productdock.library.notification.application.port.out.persistence.NotificationPersistenceOutPort;
import com.productdock.library.notification.domain.Notification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.productdock.library.notification.data.provider.domain.NotificationMother.notification;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddNotificationServiceShould {

    private static final Notification NOTIFICATION = notification();

    @InjectMocks
    private AddNotificationService addNotificationService;
    @Mock
    private NotificationPersistenceOutPort notificationPersistenceOutPort;

    @Test
    void addNotification(){
        addNotificationService.saveNotification(NOTIFICATION);

        verify(notificationPersistenceOutPort).save(NOTIFICATION);
    }
}
