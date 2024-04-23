package com.productdock.library.notification.adapter.out.mongo.mapper;

import com.productdock.library.notification.adapter.out.mongo.enitity.NotificationEntity;
import com.productdock.library.notification.domain.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NotificationEntityMapper {
    NotificationEntity toEntity(Notification source);
    Notification toDomain(NotificationEntity source);
}
