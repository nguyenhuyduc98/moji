package org.moji.backend.dto;

import lombok.Data;
import org.moji.backend.dto.response.LoginData;

@Data
public class AuthResponse {
    private boolean success;
    private String message;
    private String token;
    private UserResponse user;

    public AuthResponse(boolean success, String message, String token, UserResponse user) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.user = user;
    }
}
