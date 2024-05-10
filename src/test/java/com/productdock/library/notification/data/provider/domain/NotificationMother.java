package com.productdock.library.notification.data.provider.domain;

import com.productdock.library.notification.domain.Action;
import com.productdock.library.notification.domain.Notification;

import java.time.OffsetDateTime;

public class NotificationMother {

    public static final String defaultId = "11111";
    public static final String defaultUserId = "userEmail";
    public static final String defaultTitle = "title";
    public static final String defaultDescription = "description";
    public static final String defaultBookId = "1";
    public static final String defaultType = "bookSubscription";
    public static final Action defaultAction = Action.builder().target(defaultBookId).type(defaultType).build();

    public static Notification notification(){
        return notificationBuilder().build();
    }

    public static Notification.NotificationBuilder notificationBuilder(){
        return Notification.builder()
                .id(defaultId)
                .userId(defaultUserId)
                .title(defaultTitle)
                .read(false)
                .description(defaultDescription)
                .createdDate(OffsetDateTime.now())
                .action(defaultAction);
    }
}
