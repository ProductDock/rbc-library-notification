package com.productdock.library.notification.adapter.out.mongo;

import com.productdock.library.notification.adapter.out.mongo.mapper.NotificationEntityMapper;
import com.productdock.library.notification.domain.Notification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.productdock.library.notification.data.provider.domain.NotificationMother.notification;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificationPersistenceAdapterShould {

    private static final String USER_ID = "1";
    private static final boolean READ = false;
    private static final Notification NOTIFICATION = notification();

    @InjectMocks
    private NotificationPersistenceAdapter notificationPersistenceAdapter;
    @Mock
    private NotificationRepository notificationRepository;
    @Mock
    private NotificationEntityMapper notificationEntityMapper;

    @Test
    void getAllNotificationsForUser() {
        notificationPersistenceAdapter.getAllByUserId(USER_ID);

        verify(notificationRepository).findAllByUserId(USER_ID);
    }

    @Test
    void getUnreadNotificationsForUser() {
        notificationPersistenceAdapter.getUnreadByUserId(USER_ID);

        verify(notificationRepository).findAllByReadAndUserId(READ, USER_ID);
    }

    @Test
    void saveAll(){
        var notifications = new ArrayList<Notification>();
        notifications.add(NOTIFICATION);
        notificationPersistenceAdapter.saveAll(notifications);

        verify(notificationRepository).saveAll(any());
    }
}
