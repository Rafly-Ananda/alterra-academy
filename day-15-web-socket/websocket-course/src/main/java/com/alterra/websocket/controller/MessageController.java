package com.alterra.websocket.controller;

import com.alterra.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message greet(Message message) throws Exception {
        Thread.sleep(1000);
        return new Message(message.getFrom(), message.getText());
    }

}
