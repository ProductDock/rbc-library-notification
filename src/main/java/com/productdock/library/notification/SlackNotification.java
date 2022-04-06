package com.productdock.library.notification;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.users.UsersLookupByEmailRequest;
import com.slack.api.methods.response.users.UsersLookupByEmailResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlackNotification {

    @Value("${slack.oauth.token}")
    private String SLACK_OAUTH_TOKEN;


    public void sendMessage(NotificationDTO notificationDTO) throws SlackApiException, IOException {
        Slack slack = Slack.getInstance();

        UsersLookupByEmailResponse userResponse = slack.methods(SLACK_OAUTH_TOKEN)
                .usersLookupByEmail(UsersLookupByEmailRequest.builder().email(notificationDTO.email).build());
        if (!userResponse.isOk()) {
            return;
        }

        slack.methods(SLACK_OAUTH_TOKEN).chatPostMessage(req -> req
                .channel(userResponse.getUser().getId())
                .text(notificationDTO.message));

    }
}
