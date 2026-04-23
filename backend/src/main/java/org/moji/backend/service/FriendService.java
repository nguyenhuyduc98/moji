package org.moji.backend.service;

import org.moji.backend.model.Friend;
import org.moji.backend.repository.FriendRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FriendService {
    private final FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public Friend addFriend(Friend friend) {
        friend.setCreatedAt(LocalDateTime.now());
        friend.setUpdatedAt(LocalDateTime.now());
        return friendRepository.save(friend);
    }

    public List<Friend> getFriendsOfUser(String userId) {
        List<Friend> friendsA = friendRepository.findByUserAId(userId);
        List<Friend> friendsB = friendRepository.findByUserBId(userId);
        friendsA.addAll(friendsB);
        return friendsA;
    }
}
