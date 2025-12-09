package com.productdock.library.notification.application.port.out.persistence;

import com.productdock.library.notification.domain.Notification;

import java.util.List;

public interface NotificationPersistenceOutPort {

    List<Notification> getAllByUserId(String userId);

    List<Notification> getUnreadByUserId(String userId);

    void save(Notification notification);

    void saveAll(List<Notification> notifications);
}
