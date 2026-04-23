package org.moji.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String senderId;        // User ID
    private String conversationId;  // Conversation ID
    private String type;            // "text", "image", "file", "emoji"
    private String content;         // nội dung text
    private String imgUrl;          // link ảnh (nếu có)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getter & setter
}
