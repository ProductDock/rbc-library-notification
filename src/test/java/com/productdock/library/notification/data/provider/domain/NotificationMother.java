package com.productdock.library.notification.data.provider.domain;

import com.productdock.library.notification.domain.Action;
import com.productdock.library.notification.domain.Notification;

public class NotificationMother {

    public static final String defaultId = "11111";
    public static final String defaultUserId = "1";
    public static final String defaultTitle = "title";
    public static final String defaultDescription = "description";
    public static final String defaultBookId = "1";
    public static final String defaultType = "bookAvailable";
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
                .action(defaultAction);
    }
}
