package org.moji.backend.service;

import org.moji.backend.model.Conversation;
import org.moji.backend.repository.ConversationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Conversation createConversation(Conversation conversation) {
        conversation.setCreatedAt(LocalDateTime.now());
        conversation.setUpdatedAt(LocalDateTime.now());
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getConversationsForUser(String userId) {
        return conversationRepository.findByParticipantIdsContaining(userId);
    }

    public Optional<Conversation> getConversationById(String id) {
        return conversationRepository.findById(id);
    }
}
