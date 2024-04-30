package com.productdock.library.notification.data.provider.out.mongo;

import com.productdock.library.notification.adapter.out.mongo.enitity.ActionEntity;
import com.productdock.library.notification.adapter.out.mongo.enitity.NotificationEntity;

import java.time.OffsetDateTime;

public class NotificationEntityMother {

    public static final String defaultId = "11111";
    public static final String defaultUserId = "userEmail";
    public static final String defaultTitle = "title";
    public static final String defaultDescription = "description";
    public static final String defaultBookId = "1";
    public static final String defaultType = "bookSubscription";
    public static final ActionEntity defaultActionEntity = ActionEntity.builder().target(defaultBookId).type(defaultType).build();

    public static NotificationEntity notificationEntity(){
        return notificationBuilder().build();
    }

    public static NotificationEntity.NotificationEntityBuilder notificationBuilder(){
        return NotificationEntity.builder()
                .id(defaultId)
                .userId(defaultUserId)
                .title(defaultTitle)
                .read(false)
                .description(defaultDescription)
                .createdDate(OffsetDateTime.now().toString())
                .action(defaultActionEntity);
    }
}
