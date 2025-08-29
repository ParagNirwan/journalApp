package com.nirwan.journal_app.repository;

import com.nirwan.journal_app.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUsername(String username);
}
