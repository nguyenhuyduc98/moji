package org.moji.backend.repository;

import org.moji.backend.model.ConversationParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConversationParticipantRepository extends JpaRepository<ConversationParticipant, Long> {
    List<ConversationParticipant> findByConversationId(Long conversationId);
    List<ConversationParticipant> findByUserId(Long userId);
}
