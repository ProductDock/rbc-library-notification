package com.productdock.library.notification.application.port.in;

import com.productdock.library.notification.domain.Notification;

public interface AddNotificationUseCase {

    void saveNotification(Notification notification);
}
