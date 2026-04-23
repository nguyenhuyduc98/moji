package org.moji.backend.controller;

import org.moji.backend.model.Message;
import org.moji.backend.service.MessageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @GetMapping("/conversation/{conversationId}")
    public List<Message> getMessagesByConversation(@PathVariable Long conversationId) {
        return messageService.getMessagesByConversation(conversationId);
    }

    @GetMapping("/sender/{senderId}")
    public List<Message> getMessagesBySender(@PathVariable Long senderId) {
        return messageService.getMessagesBySender(senderId);
    }
}
