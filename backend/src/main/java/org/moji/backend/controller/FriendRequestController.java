package org.moji.backend.controller;

import org.moji.backend.model.FriendRequest;
import org.moji.backend.service.FriendRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/friend-requests")
public class FriendRequestController {
    @Autowired
    private FriendRequestService friendRequestService;

    @PostMapping
    public FriendRequest sendRequest(@RequestBody FriendRequest request) {
        return friendRequestService.sendRequest(request);
    }

    @GetMapping("/to/{userId}")
    public List<FriendRequest> getRequestsForUser(@PathVariable Long userId) {
        return friendRequestService.getRequestsForUser(userId);
    }

    @GetMapping("/from/{userId}")
    public List<FriendRequest> getRequestsFromUser(@PathVariable Long userId) {
        return friendRequestService.getRequestsFromUser(userId);
    }
}
