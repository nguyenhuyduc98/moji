package org.moji.backend.controller;

import org.moji.backend.model.Friend;
import org.moji.backend.service.FriendService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/friends")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @PostMapping
    public Friend addFriend(@RequestBody Friend friend) {
        return friendService.addFriend(friend);
    }

    @GetMapping("/{userId}")
    public List<Friend> getFriends(@PathVariable Long userId) {
        return friendService.getFriendsOfUser(userId);
    }
}
