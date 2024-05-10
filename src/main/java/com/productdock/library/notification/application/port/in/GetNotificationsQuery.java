package com.productdock.library.notification.application.port.in;

import com.productdock.library.notification.domain.Notification;

import java.util.List;

public interface GetNotificationsQuery {

    List<Notification> getNotifications(String userId);

    int getUnreadNotificationsCount(String userId);
}
