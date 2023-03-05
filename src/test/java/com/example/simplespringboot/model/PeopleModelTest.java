package com.example.simplespringboot.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PeopleModelTest {

    @Test
    void testPeople(){
        People people = new People();
        people.setId("1234");
        people.setFullName("Harist Islami");

        People people1 = new People("1234", "Harist Islami");

        assertNotNull(people);
        assertTrue(people.getFullName().equals(people1.getFullName()));
        assertTrue(people.equals(people1));
        assertNotNull(people.toString());
    }
}