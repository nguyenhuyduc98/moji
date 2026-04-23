package org.moji.backend.service;

import org.moji.backend.model.Message;
import org.moji.backend.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(Message message) {
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByConversation(String conversationId) {
        return messageRepository.findByConversationId(conversationId);
    }

    public List<Message> getMessagesBySender(String senderId) {
        return messageRepository.findBySenderId(senderId);
    }
}
