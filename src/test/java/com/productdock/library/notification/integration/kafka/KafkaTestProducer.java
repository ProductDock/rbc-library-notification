package com.productdock.library.notification.integration.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productdock.library.notification.adapter.in.kafka.messages.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestProducer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendNotificationMessage(String topic, NotificationMessage notificationMessage) throws JsonProcessingException {
        String message = OBJECT_MAPPER.writeValueAsString(notificationMessage);
        kafkaTemplate.send(topic, message);
    }
}
