package org.moji.backend.repository;

import org.moji.backend.model.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
    List<Conversation> findByParticipantIdsContaining(String userId);
}
