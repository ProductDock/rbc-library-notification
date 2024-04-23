package com.productdock.library.notification.integration;

import com.productdock.library.notification.adapter.out.mongo.NotificationRepository;
import com.productdock.library.notification.adapter.out.mongo.enitity.ActionEntity;
import com.productdock.library.notification.adapter.out.mongo.enitity.NotificationEntity;
import com.productdock.library.notification.application.port.in.GetNotificationsQuery;
import com.productdock.library.notification.domain.Notification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class GetNotificationApiTest {

    public static final String USER_ID = "userEmail";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private GetNotificationsQuery getNotificationsQuery;

    @BeforeEach
    void before() {
        notificationRepository.deleteAll();
    }

    @Test
    @WithMockUser
    void shouldReturnNotifications() throws Exception {
        givenNotification();

        mockMvc.perform(get("/api/notifications")
                        .with(jwt().jwt(jwt -> {
                            jwt.claim("email", USER_ID);
                        })))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void shouldReturnUnreadNotificationsCount() throws Exception {
        givenNotification();

        var response = mockMvc.perform(get("/api/notifications/unread")
                        .with(jwt().jwt(jwt -> {
                            jwt.claim("email", USER_ID);
                        })))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo("1");
    }

    @Test
    @WithMockUser
    void shouldMarkNotificationsAsRead() throws Exception {
        givenNotification();

        mockMvc.perform(post("/api/notifications/read")
                        .with(jwt().jwt(jwt -> {
                            jwt.claim("email", USER_ID);
                        })))
                .andExpect(status().isOk());

        var notifications = notificationRepository.findAllByUserId(USER_ID);
        notifications.forEach(notificationEntity -> assertThat(notificationEntity.isRead()).isTrue());
    }

    private void givenNotification(){
        var action = new ActionEntity("bookAvailable", "1");
        var notification = NotificationEntity.builder().userId(USER_ID).title("test").read(false).description("desc").action(action).build();
        notificationRepository.save(notification);
    }

}
