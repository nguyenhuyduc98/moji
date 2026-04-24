package org.moji.backend.dto.response;

import lombok.Data;
import org.moji.backend.dto.UserResponse;

@Data
public class LoginData {
    private String token;
    private UserResponse user;

    public LoginData(String token, UserResponse user) {
        this.token = token;
        this.user = user;
    }
}