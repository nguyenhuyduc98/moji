package org.moji.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userAId;
    private Long userBId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Friend() {}
    // constructor, getter, setter...
}
