package com.nirwan.journal_app.controller;

import com.nirwan.journal_app.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<ObjectId, JournalEntry> journalEntries = new HashMap();


    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {

        journalEntries.put(myEntry.getId(), myEntry);
        return true;

    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable Long myId) {
        journalEntries.remove(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public boolean updateEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry) {
        journalEntries.put(myId, myEntry);
        return true;
    }


}








