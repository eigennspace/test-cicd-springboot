package com.example.simplespringboot.controller;

import com.example.simplespringboot.dto.PeopleDto;
import com.example.simplespringboot.dto.PeopleRequest;
import com.example.simplespringboot.service.PeopleJSON;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/people")
@RestController
@AllArgsConstructor
public class PeopleController {

    private final PeopleJSON peopleJSON;

    @PostMapping("/create")
    public PeopleDto createPeople(@RequestBody PeopleRequest peopleRequest){
        return peopleJSON.createPeople(peopleRequest);
    }

}