package com.example.tddmenuversion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewMenuRequest {

    private String labelMenu;
    private String version;
    private boolean isActive;

}