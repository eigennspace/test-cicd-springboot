package com.example.tddmenuversion.controller;

import com.example.tddmenuversion.model.Menu;
import com.example.tddmenuversion.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{id}")
    public Menu getMenu(@PathVariable("id") Long id){
        return menuService.getMenu(id);
    }
}