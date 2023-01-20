package com.example.tddmenuversion.service;

import com.example.tddmenuversion.model.Menu;
import com.example.tddmenuversion.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu getMenu(Long id){
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}