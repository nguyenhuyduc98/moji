package org.moji.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
@Document(collection = "conversations")
public class Conversation {
    @Id
    private String id;
    private List<String> participantIds; // danh sách User ID
    private String type; // "direct" hoặc "group"

    private String groupName;
    private String groupCreatedBy; // User ID

    private String lastMessageContent;
    private LocalDateTime lastMessageCreatedAt;
    private String lastMessageSenderId;

    private List<String> seenByUserIds;
    private Map<String, Integer> unreadCounts; // userId -> số tin chưa đọc

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getter & setter
}
