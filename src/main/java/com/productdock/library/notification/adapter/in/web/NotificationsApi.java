package com.productdock.library.notification.adapter.in.web;

import com.productdock.library.notification.application.port.in.GetNotificationsQuery;
import com.productdock.library.notification.application.port.in.ReadNotificationsUseCase;
import com.productdock.library.notification.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notifications")
@Slf4j
@AllArgsConstructor
public class NotificationsApi {

    private GetNotificationsQuery getNotificationsQuery;
    private ReadNotificationsUseCase readNotificationsUseCase;

    public static final String CLAIM_EMAIL = "email";

    @GetMapping
    public List<Notification> getNotifications(Authentication authentication) {
        var userId = getUserId(authentication);
        return getNotificationsQuery.getNotifications(userId);
    }

    @GetMapping("/unread")
    public int getUnreadCount(Authentication authentication){
        var userId = getUserId(authentication);
        return getNotificationsQuery.getUnreadNotificationsCount(userId);
    }

    @PostMapping("/read")
    public void readNotifications(Authentication authentication) {
        var userId = getUserId(authentication);
        readNotificationsUseCase.markAsReadNotifications(userId);
    }

    private String getUserId(Authentication authentication) {
        return ((Jwt) authentication.getCredentials()).getClaim(CLAIM_EMAIL).toString();
    }
}
