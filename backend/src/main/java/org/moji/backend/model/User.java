package org.moji.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String hashedPassword;

    private String displayName;
    private String email;
    private String avatarUrl;
    private String bio;
    private String phone;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {}

    public User(String username, String hashedPassword, String displayName,
                String email, String avatarUrl, String bio, String phone) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.displayName = displayName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.phone = phone;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // getter & setter...
}
