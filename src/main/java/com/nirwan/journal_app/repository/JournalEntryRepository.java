package com.nirwan.journal_app.repository;

import com.nirwan.journal_app.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {

}
