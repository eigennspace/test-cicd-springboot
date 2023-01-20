package com.example.tddmenuversion.service;

import com.example.tddmenuversion.model.Menu;
import com.example.tddmenuversion.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MenuService {

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu getMenu(Long id){
        var menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException());
        log.info("Get Menu {}", menu);
        return menu;
    }
}