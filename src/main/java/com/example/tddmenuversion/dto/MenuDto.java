package com.example.tddmenuversion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private String labelMenu;
    private String version;

//    @JsonProperty("statusMenu")
    private boolean isActive;
}