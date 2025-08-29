package com.nirwan.journal_app.service;

import com.nirwan.journal_app.entity.User;
import com.nirwan.journal_app.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(String.valueOf(id));
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(String.valueOf(id));
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

}
