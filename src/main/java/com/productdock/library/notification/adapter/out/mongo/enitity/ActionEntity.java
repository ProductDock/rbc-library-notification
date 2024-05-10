package com.productdock.library.notification.adapter.out.mongo.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActionEntity implements Serializable {
    private String type;
    private String target;
}
