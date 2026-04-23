package org.moji.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;       // unique
    private String hashedPassword; // lưu bằng BCrypt
    private String displayName;
    private String email;          // unique
    private String avatarUrl;
    private String bio;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    public User() {}
//
//    public User(String username, String hashedPassword, String displayName,
//                String email, String avatarUrl, String bio, String phone) {
//        this.username = username;
//        this.hashedPassword = hashedPassword;
//        this.displayName = displayName;
//        this.email = email;
//        this.avatarUrl = avatarUrl;
//        this.bio = bio;
//        this.phone = phone;
//    }

//    // Getter & Setter cho phone
//    public String getPhone() {
//        return phone;
//    }
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
}
