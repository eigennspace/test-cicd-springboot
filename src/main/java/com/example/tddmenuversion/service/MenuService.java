package com.example.tddmenuversion.service;

import com.example.tddmenuversion.dto.CreateNewMenuRequest;
import com.example.tddmenuversion.dto.MenuDto;
import com.example.tddmenuversion.model.Menu;
import com.example.tddmenuversion.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

//    public MenuDto createNewMenu(CreateNewMenuRequest createNewMenuRequest){
//        var doConvertMenu = new Menu();
//        BeanUtils.copyProperties(createNewMenuRequest, doConvertMenu);
//
//        var menu = menuRepository.save(doConvertMenu);
//
//        MenuDto menuDto = new MenuDto();
//        BeanUtils.copyProperties(menu, menuDto);
//
//        return menuDto;
//    }

    public MenuDto createNewMenu(CreateNewMenuRequest createNewMenuRequest){
        var doConvertMenu = new Menu();
        BeanUtils.copyProperties(createNewMenuRequest, doConvertMenu);

        var menu = menuRepository.save(doConvertMenu);

        MenuDto menuDto = new MenuDto();
        BeanUtils.copyProperties(menu, menuDto);

        return menuDto;
    }
}