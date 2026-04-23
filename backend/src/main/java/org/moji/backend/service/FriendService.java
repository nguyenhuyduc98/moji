package org.moji.backend.service;

import org.moji.backend.model.Friend;
import org.moji.backend.repository.FriendRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;

    public Friend addFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    public List<Friend> getFriendsOfUser(Long userId) {
        List<Friend> friendsA = friendRepository.findByUserAId(userId);
        List<Friend> friendsB = friendRepository.findByUserBId(userId);
        friendsA.addAll(friendsB);
        return friendsA;
    }
}
