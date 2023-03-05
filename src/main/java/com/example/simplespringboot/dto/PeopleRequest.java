package com.example.simplespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PeopleRequest {
    private String firstName;
    private String lastName;
}