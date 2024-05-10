package com.productdock.library.notification.adapter.out.mongo.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEntity implements Serializable {
    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private boolean read;
    private String createdDate;
    private ActionEntity action;
}
