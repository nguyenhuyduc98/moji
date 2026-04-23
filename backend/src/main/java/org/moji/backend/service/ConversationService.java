package org.moji.backend.service;

import org.moji.backend.model.Conversation;
import org.moji.backend.model.ConversationParticipant;
import org.moji.backend.repository.ConversationParticipantRepository;
import org.moji.backend.repository.ConversationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ConversationParticipantRepository participantRepository;

    public Conversation createConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public void addParticipant(Long conversationId, Long userId) {
        ConversationParticipant participant = new ConversationParticipant(conversationId, userId);
        participantRepository.save(participant);
    }

    public List<ConversationParticipant> getParticipants(Long conversationId) {
        return participantRepository.findByConversationId(conversationId);
    }
}
