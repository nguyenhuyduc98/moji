package org.moji.backend.controller;

import org.moji.backend.model.User;
import org.moji.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String username,
                         @RequestParam String password) {
        return "accessToken";
    }

    @PostMapping("/signout")
    public String signout() {
        return "Signed out";
    }

    @PostMapping("/refresh")
    public String refreshToken(@RequestParam String refreshToken) {
        return "newAccessToken";
    }
}
