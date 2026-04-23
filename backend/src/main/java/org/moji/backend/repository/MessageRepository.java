package org.moji.backend.repository;

import org.moji.backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByConversationId(Long conversationId);
    List<Message> findBySenderId(Long senderId);
}
