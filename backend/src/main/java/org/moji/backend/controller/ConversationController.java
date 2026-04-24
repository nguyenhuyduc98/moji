package org.moji.backend.controller;

import org.moji.backend.model.Conversation;
import org.moji.backend.model.ConversationParticipant;
import org.moji.backend.service.ConversationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {
    @Autowired
    private ConversationService conversationService;

    @PostMapping
    public Conversation createConversation(@RequestBody Conversation conversation) {
        return conversationService.createConversation(conversation);
    }

    @PostMapping("/{conversationId}/participants/{userId}")
    public void addParticipant(@PathVariable Long conversationId, @PathVariable Long userId) {
        conversationService.addParticipant(conversationId, userId);
    }

    @GetMapping("/{conversationId}/participants")
    public List<ConversationParticipant> getParticipants(@PathVariable Long conversationId) {
        return conversationService.getParticipants(conversationId);
    }
}
