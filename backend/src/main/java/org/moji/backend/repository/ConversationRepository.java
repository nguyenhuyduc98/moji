package org.moji.backend.repository;

import org.moji.backend.model.Conversation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}
