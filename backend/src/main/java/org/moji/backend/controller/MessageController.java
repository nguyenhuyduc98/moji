package org.moji.backend.controller;

import org.moji.backend.model.Message;
import org.moji.backend.service.MessageService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/direct")
    public Message sendDirectMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @PostMapping("/group")
    public Message sendGroupMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}

