package org.moji.backend.repository;

import org.moji.backend.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByConversationId(String conversationId);
    List<Message> findBySenderId(String senderId);
}
