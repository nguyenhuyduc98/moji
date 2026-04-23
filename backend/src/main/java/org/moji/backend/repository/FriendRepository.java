package org.moji.backend.repository;

import org.moji.backend.model.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FriendRepository extends MongoRepository<Friend, String> {
    List<Friend> findByUserAId(String userAId);
    List<Friend> findByUserBId(String userBId);
}
