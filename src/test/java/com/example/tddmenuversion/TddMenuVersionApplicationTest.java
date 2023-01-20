package com.example.tddmenuversion;

import com.example.tddmenuversion.repository.MenuRepository;
import com.example.tddmenuversion.service.MenuService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TddMenuVersionApplicationTest {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MenuService menuService;

    @BeforeEach
    void addMenu(){
        jdbcTemplate.execute("INSERT INTO menu(id,label_menu,version,is_active,is_deleted) VALUES (1,'Purchase Gopay','1.0.1',true,false)");
    }

    @Test
    void getDataMenu(){
        var menu = menuRepository.findById(1L);
        assertNotNull(menu.get());
        System.out.println(menu.get());
    }

    @Test
    void getDataMenuServices(){
        var menu = menuService.getMenu(1L);
        assertNotNull(menu);
        System.out.println(menu);
    }

    @Test
    void getDataMenuNotFoundServices(){

        assertThrows(RuntimeException.class, () ->
                menuService.getMenu(2L)
        );

    }

    @AfterEach
    void deleteMenu(){
        menuRepository.deleteAll();
    }

}