package com.productdock.library.notification.adapter.out.mongo.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ActionEntity {
    private String type;
    private String target;
}
