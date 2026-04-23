package org.moji.backend.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String phone;
    // getter & setter
}
