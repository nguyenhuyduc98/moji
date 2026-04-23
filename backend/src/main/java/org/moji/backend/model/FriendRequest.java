package org.moji.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "friend_requests")
public class FriendRequest {
    @Id
    private String id;
    private String fromUserId;   // tham chiếu User
    private String toUserId;     // tham chiếu User
    private String message;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getter & setter
}
