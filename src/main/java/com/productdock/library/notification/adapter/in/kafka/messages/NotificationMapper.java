package com.productdock.library.notification.adapter.in.kafka.messages;

import com.productdock.library.notification.domain.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NotificationMapper {

    @Mapping(target = "read", ignore = true)
    @Mapping(target = "id", ignore = true)
    public Notification toDomain(NotificationMessage source);
}
