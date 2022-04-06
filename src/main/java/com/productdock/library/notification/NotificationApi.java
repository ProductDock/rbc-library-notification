package com.productdock.library.notification;

import com.productdock.library.notification.consumer.messages.Notification;
import com.productdock.library.notification.slack.SlackNotificationSender;
import com.slack.api.methods.SlackApiException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/notify")
public record NotificationApi(SlackNotificationSender slackNotification) {

    @PostMapping("/slack")
    public void sendSlackNotification(@RequestBody Notification notification) {
        try {
            slackNotification.sendMessage(notification);
        } catch (SlackApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
