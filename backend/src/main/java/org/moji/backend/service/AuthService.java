package org.moji.backend.service;

import org.moji.backend.dto.LoginRequest;
import org.moji.backend.dto.RegisterRequest;
import org.moji.backend.dto.UserResponse;
import org.moji.backend.dto.response.LoginData;
import org.moji.backend.dto.response.RefreshData;
import org.moji.backend.model.User;
import org.moji.backend.repository.UserRepository;
import org.moji.backend.security.JwtService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public UserResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username đã tồn tại");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email đã tồn tại");
        }

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()), // mã hóa mật khẩu
                request.getDisplayName(),
                request.getEmail(),
                null,
                null,
                request.getPhone()
        );
        return new UserResponse(
                user.getUsername(),
                user.getDisplayName(),
                user.getEmail(),
                user.getPhone()
        );
    }


    public LoginData login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Sai username hoặc password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getHashedPassword())) {
            throw new RuntimeException("Sai username hoặc password");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new LoginData(
                token,
                new UserResponse(user.getUsername(), user.getDisplayName(), user.getEmail(), user.getPhone())
        );
    }

    public void logout(String token) {
        System.out.println("Token đã logout: " + token);
    }

    public RefreshData refreshToken(String refreshToken) {
        if (!jwtService.validateToken(refreshToken)) {
            throw new RuntimeException("Refresh token không hợp lệ hoặc đã hết hạn");
        }

        String username = jwtService.extractUsername(refreshToken);
        String newAccessToken = jwtService.generateToken(username);

        return new RefreshData(newAccessToken);
    }
}

