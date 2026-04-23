package org.moji.backend.repository;

import org.moji.backend.model.FriendRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FriendRequestRepository extends MongoRepository<FriendRequest, String> {
    List<FriendRequest> findByToUserId(String toUserId);
    List<FriendRequest> findByFromUserId(String fromUserId);
}
