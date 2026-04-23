package org.moji.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "friends")
public class Friend {
    @Id
    private String id;
    private String userAId;   // tham chiếu User
    private String userBId;   // tham chiếu User
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getter & setter
}
