package com.productdock.library.notification.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
public class Notification {
    private String id;
    private String title;
    private String description;
    private String userId;
    private boolean read;
    private OffsetDateTime createdDate;
    private Action action;
}
