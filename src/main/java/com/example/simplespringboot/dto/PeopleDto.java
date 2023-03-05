package com.example.simplespringboot.dto;

import lombok.*;

@Builder
@AllArgsConstructor
public class PeopleDto {
    private String id;
    private String fullName;

    public String getFullName(){
        return fullName;
    }

    public String getId(){
        return id;
    }
}