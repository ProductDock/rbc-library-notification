package com.productdock.library.notification.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productdock.library.notification.consumer.messages.Notification;
import com.productdock.library.notification.slack.SlackNotificationSender;
import com.slack.api.methods.SlackApiException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public record KafkaConsumer(SlackNotificationSender slackNotification, ObjectMapper objectMapper) {


    @KafkaListener(topics = "${spring.kafka.topic.notifications-topic}",
            containerFactory = "notificationDTOKafkaListenerContainerFactory")
    public synchronized void listen(Notification notification){
        System.out.println("Message received!");
        try {
            slackNotification.sendMessage(notification);
        } catch (SlackApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
