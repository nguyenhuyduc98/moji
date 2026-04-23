package org.moji.backend.service;

import org.moji.backend.dto.SignupRequest;
import org.moji.backend.model.User;
import org.moji.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signup(SignupRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username đã tồn tại");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email đã tồn tại");
        }

        // Tạo user mới
        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()), // mã hóa mật khẩu
                request.getDisplayName(),
                request.getEmail(),
                null,
                null,
                request.getPhone()
        );
        return userRepository.save(user);
    }
}

