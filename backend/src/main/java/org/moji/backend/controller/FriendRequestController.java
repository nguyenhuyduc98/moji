package org.moji.backend.controller;

import org.moji.backend.model.FriendRequest;
import org.moji.backend.service.FriendRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/friend-requests")
public class FriendRequestController {
    private final FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @PostMapping("/send")
    public FriendRequest sendRequest(@RequestBody FriendRequest request) {
        return friendRequestService.sendRequest(request);
    }

    @GetMapping("/to/{userId}")
    public List<FriendRequest> getRequestsForUser(@PathVariable String userId) {
        return friendRequestService.getRequestsForUser(userId);
    }

    @GetMapping("/from/{userId}")
    public List<FriendRequest> getRequestsFromUser(@PathVariable String userId) {
        return friendRequestService.getRequestsFromUser(userId);
    }
}
