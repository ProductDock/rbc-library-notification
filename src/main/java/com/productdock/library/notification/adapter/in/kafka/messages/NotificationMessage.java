package com.productdock.library.notification.adapter.in.kafka.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
public class NotificationMessage {
    public final String title;
    public final String description;
    public final String userId;
    public final ActionMessage action;
}
