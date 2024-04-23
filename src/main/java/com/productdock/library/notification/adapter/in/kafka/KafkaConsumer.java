package com.productdock.library.notification.adapter.in.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productdock.library.notification.adapter.in.kafka.messages.NotificationMapper;
import com.productdock.library.notification.adapter.in.kafka.messages.NotificationMessage;
import com.productdock.library.notification.application.port.in.AddNotificationUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {

    private NotificationMapper notificationMapper;
    private ObjectMapper objectMapper;
    private AddNotificationUseCase addNotificationUseCase;

    @KafkaListener(topics = "${spring.kafka.topic.notifications}")
    public synchronized void listenNotifications(ConsumerRecord<String, String> message) throws JsonProcessingException {
        log.debug("Received notification kafka message: {}", message);

        var bookRentalStatusChanged = objectMapper.readValue(message.value(), NotificationMessage.class);
        var notification = notificationMapper.toDomain(bookRentalStatusChanged);
        addNotificationUseCase.saveNotification(notification);
    }
}
