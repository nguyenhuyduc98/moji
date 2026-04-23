package org.moji.backend.service;

import org.moji.backend.model.FriendRequest;
import org.moji.backend.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;

    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    public FriendRequest sendRequest(FriendRequest request) {
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());
        return friendRequestRepository.save(request);
    }

    public List<FriendRequest> getRequestsForUser(String userId) {
        return friendRequestRepository.findByToUserId(userId);
    }

    public List<FriendRequest> getRequestsFromUser(String userId) {
        return friendRequestRepository.findByFromUserId(userId);
    }
}
