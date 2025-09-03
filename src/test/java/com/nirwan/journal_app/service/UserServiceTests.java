package com.nirwan.journal_app.service;

import com.nirwan.journal_app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;


    @ParameterizedTest
    @ValueSource(strings = {
            "parag",
            "jojo",
            "kraken",
    })
    public void findByUsername(String name) {
        assertNotNull(userRepository.findUserByUsername(name));
    }
}
