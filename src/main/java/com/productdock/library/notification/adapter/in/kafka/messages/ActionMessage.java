package com.productdock.library.notification.adapter.in.kafka.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ActionMessage {
    private String type;
    private String target;
}
