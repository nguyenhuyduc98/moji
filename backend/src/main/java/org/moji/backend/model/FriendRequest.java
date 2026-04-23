package org.moji.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "friend_requests")
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromUserId;
    private Long toUserId;
    private String message;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FriendRequest() {}
    // constructor, getter, setter...
}
