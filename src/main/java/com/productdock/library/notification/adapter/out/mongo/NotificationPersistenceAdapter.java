package com.productdock.library.notification.adapter.out.mongo;

import com.productdock.library.notification.adapter.out.mongo.mapper.NotificationEntityMapper;
import com.productdock.library.notification.application.port.out.persistence.NotificationPersistenceOutPort;
import com.productdock.library.notification.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@AllArgsConstructor
public class NotificationPersistenceAdapter implements NotificationPersistenceOutPort {

    private NotificationRepository notificationRepository;
    private NotificationEntityMapper mapper;
    private MongoTemplate mongoTemplate;

    @Override
    public List<Notification> getAllByUserId(String userId) {
        return notificationRepository.findAllByUserId(userId)
                .stream().map(notificationEntity -> mapper.toDomain(notificationEntity)).toList();
    }

    @Override
    public List<Notification> getUnreadByUserId(String userId) {
        return notificationRepository.findAllByReadAndUserId(false, userId)
                .stream().map(notificationEntity -> mapper.toDomain(notificationEntity)).toList();
    }

    @Override
    public void save(Notification notification) {
        log.info("Notification for saving: {}", notification);
        var saved = notificationRepository.save(mapper.toEntity(notification));
        log.info("Saved notification: {}", saved);
    }

    @Override
    public void saveAll(List<Notification> notifications) {
        notificationRepository.saveAll(notifications.stream().map(notification -> mapper.toEntity(notification)).toList());
    }
}
