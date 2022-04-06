package com.productdock.library.notification;

import com.slack.api.methods.SlackApiException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/notify")
public record NotifyApi(SlackNotification slackNotification) {

    @PostMapping("/slack")
    public void sendSlackNotification(@RequestBody NotificationDTO notificationDTO) {
        try {
            slackNotification.sendMessage(notificationDTO);
        } catch (SlackApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
