package com.nirwan.journal_app.service;

import com.nirwan.journal_app.entity.JournalEntry;
import com.nirwan.journal_app.entity.User;
import com.nirwan.journal_app.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList("User"));
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user); // No password encoding here
    }

    public void addJournalEntryToUser(User user, JournalEntry journalEntry) {
        user.getJournalEntries().add(journalEntry);
        userRepository.save(user);
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

}
