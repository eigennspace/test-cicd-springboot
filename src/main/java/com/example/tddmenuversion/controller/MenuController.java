package com.example.tddmenuversion.controller;

import com.example.tddmenuversion.dto.CreateNewMenuRequest;
import com.example.tddmenuversion.dto.MenuDto;
import com.example.tddmenuversion.model.Menu;
import com.example.tddmenuversion.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/createNewMenu")
    public MenuDto createMenu(CreateNewMenuRequest createNewMenuRequest){
        return menuService.createNewMenu(createNewMenuRequest);
    }

    @GetMapping("/getAll")
    public List<Menu> getAllMenu(){
        return menuService.getAllMenu();
    }
}