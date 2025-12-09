package com.productdock.library.notification.adapter.in.kafka.messages;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.productdock.library.notification.data.provider.in.kafka.NotificationMessageMother.notificationMessage;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {NotificationMapperImpl.class})
class NotificationMapperShould {

    @Autowired
    private NotificationMapper notificationMapper;

    @Test
    void mapMessageToDomain() {
        var notificationMessage = notificationMessage();

        var notification = notificationMapper.toDomain(notificationMessage);

        assertThat(notification.getTitle()).isEqualTo(notificationMessage.title);
        assertThat(notification.getDescription()).isEqualTo(notificationMessage.description);
        assertThat(notification.getAction().getType()).isEqualTo(notificationMessage.action.getType());
        assertThat(notification.getAction().getTarget()).isEqualTo(notificationMessage.action.getTarget());
        assertThat(notification.isRead()).isFalse();
        assertThat(notification.getCreatedDate()).isNull();
        assertThat(notification.getId()).isNull();
    }
}
