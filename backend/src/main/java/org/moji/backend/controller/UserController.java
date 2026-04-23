package org.moji.backend.controller;

import org.moji.backend.model.User;
import org.moji.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public User getMe() {
        return new User();
    }

    @GetMapping("/search")
    public User searchUser(@RequestParam String username) {
        return userService.findByUsername(username).orElse(null);
    }

    @PostMapping("/uploadAvatar")
    public String uploadAvatar() {
        return "avatarUrl";
    }

    @PatchMapping("/me")
    public User updateProfile(@RequestBody User user) {
        return user;
    }
}
