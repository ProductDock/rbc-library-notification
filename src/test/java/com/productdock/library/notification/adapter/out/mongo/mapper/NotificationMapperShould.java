package com.productdock.library.notification.adapter.out.mongo.mapper;

import com.productdock.library.notification.adapter.out.mongo.enitity.ActionEntity;
import com.productdock.library.notification.adapter.out.mongo.enitity.NotificationEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.productdock.library.notification.data.provider.domain.NotificationMother.notification;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {NotificationEntityMapperImpl.class})
class NotificationMapperShould {

    @Autowired
    private NotificationEntityMapper notificationEntityMapper;

    @Test
    void mapNotificationToNotificationEntity(){
        var notification = notification();
        var notificationEntity = notificationEntityMapper.toEntity(notification);

        assertThat(notificationEntity.getId()).isEqualTo(notification.getId());
        assertThat(notificationEntity.getUserId()).isEqualTo(notification.getUserId());
        assertThat(notificationEntity.getTitle()).isEqualTo(notification.getTitle());
        assertThat(notificationEntity.getDescription()).isEqualTo(notification.getDescription());
        assertThat(notificationEntity.isRead()).isEqualTo(notification.isRead());
        assertThat(notificationEntity.getAction().getTarget()).isEqualTo(notification.getAction().getTarget());
        assertThat(notificationEntity.getAction().getType()).isEqualTo(notification.getAction().getType());
    }

    @Test
    void mapNotificationEntityToNotification(){
        var notificationEntity = givenNotificationEntity();
        var notification = notificationEntityMapper.toDomain(notificationEntity);

        assertThat(notification.getId()).isEqualTo(notificationEntity.getId());
        assertThat(notification.getTitle()).isEqualTo(notificationEntity.getTitle());
        assertThat(notification.getDescription()).isEqualTo(notificationEntity.getDescription());
        assertThat(notification.getUserId()).isEqualTo(notificationEntity.getUserId());
        assertThat(notification.getAction().getTarget()).isEqualTo(notification.getAction().getTarget());
        assertThat(notification.getAction().getType()).isEqualTo(notification.getAction().getType());
    }

    private NotificationEntity givenNotificationEntity(){
        var actionEntity = ActionEntity.builder().target("1").type("bookAvailable").build();
        var entity = NotificationEntity.builder()
                .id("1")
                .userId("email")
                .title("title")
                .read(false)
                .description("description")
                .action(actionEntity)
                .build();

        return entity;
    }

}
