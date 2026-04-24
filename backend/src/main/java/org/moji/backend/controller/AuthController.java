package org.moji.backend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.moji.backend.dto.LoginRequest;
import org.moji.backend.dto.RegisterRequest;
import org.moji.backend.dto.UserResponse;
import org.moji.backend.dto.response.LoginData;
import org.moji.backend.dto.response.RefreshData;
import org.moji.backend.service.AuthService;
import org.moji.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@RequestBody RegisterRequest request) {
        try {
            UserResponse user = authService.register(request);
            return ResponseEntity.ok(new ApiResponse<>(true, "Đăng ký thành công", user));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(false, e.getMessage(), null));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginData>> login(@RequestBody LoginRequest request) {
        LoginData response = authService.login(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Đăng nhập thành công", response));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Object>> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            authService.logout(token);
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Đăng xuất thành công", new Object()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<RefreshData>> refresh(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        RefreshData refreshData = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cấp lại access token thành công", refreshData));
    }
}
