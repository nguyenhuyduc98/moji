package org.moji.backend.controller;

import org.moji.backend.model.Friend;
import org.moji.backend.model.FriendRequest;
import org.moji.backend.service.FriendRequestService;
import org.moji.backend.service.FriendService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/friends")
public class FriendController {
    private final FriendService friendService;
    private final FriendRequestService friendRequestService;

    public FriendController(FriendService friendService, FriendRequestService friendRequestService) {
        this.friendService = friendService;
        this.friendRequestService = friendRequestService;
    }

    @PostMapping("/requests")
    public FriendRequest sendRequest(@RequestBody FriendRequest request) {
        return friendRequestService.sendRequest(request);
    }

    @PostMapping("/requests/{requestId}/accept")
    public String acceptRequest(@PathVariable String requestId) {
        return "Friend accepted";
    }

    @PostMapping("/requests/{requestId}/decline")
    public String declineRequest(@PathVariable String requestId) {
        return "Friend declined";
    }

    @GetMapping("/")
    public List<Friend> getFriends() {
        return List.of();
    }

    @GetMapping("/requests")
    public String getRequests() {
        return "{sent:[], received:[]}";
    }
}
