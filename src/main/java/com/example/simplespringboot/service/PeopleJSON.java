package com.example.simplespringboot.service;

import com.example.simplespringboot.dto.PeopleDto;
import com.example.simplespringboot.dto.PeopleRequest;
import com.example.simplespringboot.model.People;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PeopleJSON {

    public PeopleDto createPeople(PeopleRequest peopleRequest){
        People people = new People();
        people.setId(UUID.randomUUID().toString());
        people.setFullName(peopleRequest.getFirstName() +" "+ peopleRequest.getLastName());

        return PeopleDto.builder()
                .id(people.getId())
                .fullName(people.getFullName()).build();
    }

}