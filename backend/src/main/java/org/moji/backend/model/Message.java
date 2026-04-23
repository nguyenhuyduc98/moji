package org.moji.backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long conversationId;
    private Long senderId;
    private String content;
    private String imgUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Message() {}
    // constructor, getter, setter...
}
