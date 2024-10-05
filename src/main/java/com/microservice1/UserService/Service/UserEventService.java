package com.microservice1.UserService.Service;

import com.microservice1.UserService.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class UserEventService   {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void emitUserRegisteredEvent(User user) {
        kafkaTemplate.send("user_registered", user.getId().toString());
    }
}
