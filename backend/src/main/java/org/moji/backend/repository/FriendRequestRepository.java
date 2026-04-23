package org.moji.backend.repository;

import org.moji.backend.model.FriendRequest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    List<FriendRequest> findByToUserId(Long toUserId);
    List<FriendRequest> findByFromUserId(Long fromUserId);
}
