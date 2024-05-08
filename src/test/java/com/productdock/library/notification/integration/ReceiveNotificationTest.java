package com.productdock.library.notification.integration;

import com.productdock.library.notification.adapter.in.kafka.messages.NotificationMessage;
import com.productdock.library.notification.adapter.out.mongo.NotificationRepository;
import com.productdock.library.notification.integration.kafka.KafkaTestBase;
import com.productdock.library.notification.integration.kafka.KafkaTestProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.annotation.DirtiesContext;

import static com.productdock.library.notification.data.provider.in.kafka.NotificationMessageMother.notificationMessage;

@SpringBootTest
@Slf4j
@DirtiesContext
public class ReceiveNotificationTest extends KafkaTestBase {

    public static final NotificationMessage NOTIFICATION_MESSAGE = notificationMessage();
    @Autowired
    private KafkaTestProducer producer;
    @Autowired
    private NotificationRepository notificationRepository;
    @Value("${spring.kafka.topic.notifications}")
    private String topic;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void before() {
        mongoTemplate.remove(new Query(), "notifications");
       // notificationRepository.deleteAll();
    }

//    @Test
//    void shouldSaveNotification_whenMessageReceived() throws JsonProcessingException {
//        producer.sendNotificationMessage(topic, NOTIFICATION_MESSAGE);
//
//        await()
//                .atMost(Duration.ofSeconds(20))
//                .until(() -> {
//                    log.info("Fetching...");
//                    List<NotificationEntity> savedNotification = notificationRepository.findAll();
//                    log.info("Fetched notifications:{}", savedNotification);
//                    return !savedNotification.isEmpty();
//                });
//
//        assertThat(notificationRepository.findAllByUserId(NOTIFICATION_MESSAGE.userId)).isNotEmpty();
//    }
}
