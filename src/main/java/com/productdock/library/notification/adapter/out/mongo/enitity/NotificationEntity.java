package com.productdock.library.notification.adapter.out.mongo.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notifications")
@Data
@AllArgsConstructor
@Builder
public class NotificationEntity {
    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private boolean read;
    private String createdDate;
    private ActionEntity action;
}
