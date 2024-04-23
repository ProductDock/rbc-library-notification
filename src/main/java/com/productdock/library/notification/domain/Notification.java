package com.productdock.library.notification.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Notification {
    private String id;
    private String title;
    private String description;
    private String userId;
    private boolean read;
    private Action action;
}
