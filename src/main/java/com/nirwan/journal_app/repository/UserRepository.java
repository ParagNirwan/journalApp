package com.nirwan.journal_app.repository;

import com.nirwan.journal_app.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findUserByUsername(String username);

    void deleteByUsername(String username);
}
