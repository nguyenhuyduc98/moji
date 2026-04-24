package org.moji.backend.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String username;
    private String displayName;
    private String email;
    private String phone;

    public UserResponse(String username, String displayName, String email, String phone) {
        this.username = username;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
    }
}
