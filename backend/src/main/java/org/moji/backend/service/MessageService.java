package org.moji.backend.service;

import org.moji.backend.model.Message;
import org.moji.backend.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByConversation(Long conversationId) {
        return messageRepository.findByConversationId(conversationId);
    }

    public List<Message> getMessagesBySender(Long senderId) {
        return messageRepository.findBySenderId(senderId);
    }
}
