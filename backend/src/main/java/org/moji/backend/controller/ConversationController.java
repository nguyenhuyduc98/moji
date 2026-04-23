package org.moji.backend.controller;

import org.moji.backend.model.Conversation;
import org.moji.backend.model.Message;
import org.moji.backend.service.ConversationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {
    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/")
    public Conversation createConversation(@RequestBody Conversation conversation) {
        return conversationService.createConversation(conversation);
    }

    @GetMapping("/")
    public List<Conversation> getConversations() {
        return conversationService.getConversationsForUser("userId");
    }

    @GetMapping("/{conversationId}/message")
    public List<Message> getMessages(@PathVariable String conversationId) {
        return List.of();
    }

    @PatchMapping("/{conversationId}/seen")
    public String markSeen(@PathVariable String conversationId) {
        return "Seen updated";
    }
}
