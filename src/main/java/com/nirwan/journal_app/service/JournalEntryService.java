package com.nirwan.journal_app.service;


import com.nirwan.journal_app.entity.JournalEntry;
import com.nirwan.journal_app.entity.User;
import com.nirwan.journal_app.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;



    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
        User user = userService.findByUsername(username);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.updateUser(user);
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }


    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(String.valueOf(id));
    }

    public void deleteEntryById(ObjectId id, String username) {
        User user = userService.findByUsername(username);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.updateUser(user);
        journalEntryRepository.deleteById(String.valueOf(id));
    }


}
