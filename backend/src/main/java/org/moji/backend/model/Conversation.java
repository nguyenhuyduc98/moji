package org.moji.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // direct or group
    private String name;

    @ElementCollection
    private List<Long> participantIds;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Conversation() {}
    // constructor, getter, setter...
}
