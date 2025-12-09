package com.productdock.library.notification.data.provider.in.kafka;

import com.productdock.library.notification.adapter.in.kafka.messages.ActionMessage;
import com.productdock.library.notification.adapter.in.kafka.messages.NotificationMessage;

public class NotificationMessageMother {

    private static final String defaultTitle = "title";
    private static final String defaultDescription = "description";
    private static final String defaultUserId = "userEmail";
    private static final String defalutType = "bookSubscription";
    private static final String defaultTarget = "1";
    private static final ActionMessage defaultAction = ActionMessage.builder().type(defalutType).target(defaultTarget).build();


    public static NotificationMessage notificationMessage() {
        return notificationMessageBuilder().build();
    }

    public static  NotificationMessage.NotificationMessageBuilder notificationMessageBuilder() {
        return NotificationMessage.builder()
                .title(defaultTitle)
                .description(defaultDescription)
                .userId(defaultUserId)
                .action(defaultAction);
    }
}
