package org.moji.backend.service;

import org.moji.backend.model.FriendRequest;
import org.moji.backend.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FriendRequestService {
    @Autowired
    private FriendRequestRepository friendRequestRepository;

    public FriendRequest sendRequest(FriendRequest request) {
        return friendRequestRepository.save(request);
    }

    public List<FriendRequest> getRequestsForUser(Long userId) {
        return friendRequestRepository.findByToUserId(userId);
    }

    public List<FriendRequest> getRequestsFromUser(Long userId) {
        return friendRequestRepository.findByFromUserId(userId);
    }
}
