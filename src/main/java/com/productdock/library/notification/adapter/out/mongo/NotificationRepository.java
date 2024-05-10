package com.productdock.library.notification.adapter.out.mongo;

import com.productdock.library.notification.adapter.out.mongo.enitity.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {

    List<NotificationEntity> findAllByUserId(String userId);

    List<NotificationEntity> findAllByReadAndUserId(boolean read, String userId);
}
