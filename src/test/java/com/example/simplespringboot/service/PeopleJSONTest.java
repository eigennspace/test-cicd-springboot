package com.example.simplespringboot.service;

import com.example.simplespringboot.dto.PeopleDto;
import com.example.simplespringboot.dto.PeopleRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PeopleJSONTest {

    @Autowired
    PeopleJSON peopleJSON;

    @Test
    void createPeople(){
        var result = peopleJSON.createPeople(new PeopleRequest("Harist", "Islami"));
        assertEquals(new PeopleDto("1", "Harist Islami").getFullName(), result.getFullName());
    }
}