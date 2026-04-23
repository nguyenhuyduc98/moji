package org.moji.backend.repository;

import org.moji.backend.model.Friend;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findByUserAId(Long userAId);
    List<Friend> findByUserBId(Long userBId);
}
