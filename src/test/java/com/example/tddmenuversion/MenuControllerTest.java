package com.example.tddmenuversion;

import com.example.tddmenuversion.dto.CreateNewMenuRequest;
import com.example.tddmenuversion.model.Menu;
import com.example.tddmenuversion.repository.MenuRepository;
import com.example.tddmenuversion.service.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MenuControllerTest {


    private static MockHttpServletRequest request;

    @PersistenceContext
    private EntityManager entityManager;

    @Mock
    MenuService menuService;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeAll
    static void setup(){

        request = new MockHttpServletRequest();
        request.setParameter("labelMenu", "Menu Servlet");
        request.setParameter("version", "1.2.3");
        request.setParameter("active", String.valueOf(Boolean.TRUE));
    }

    @BeforeEach
    void addMenu(){
        jdbcTemplate.execute("INSERT INTO menu(id,label_menu,version,is_active,is_deleted) VALUES (99,'Purchase Gopay','1.0.1',true,false)");
    }

    // INFO: 09/02/2023  -> use this if controller use RequestBody

//    @Test
//    void controllerCreateNewMenu() throws Exception {
//        CreateNewMenuRequest menuRequest = new CreateNewMenuRequest();
//        menuRequest.setLabelMenu("TEST");
//        menuRequest.setVersion("1.1.1");
//        menuRequest.setActive(Boolean.TRUE);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/v1/menu/createNewMenu")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(menuRequest)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(jsonPath("$.*", hasSize(3)))
//                .andExpect(jsonPath("$.labelMenu", is("TEST")))
//                .andExpect(jsonPath("$.active", is(Boolean.TRUE)));
//    }

    // INFO: 09/02/2023  -> use this if controller not use RequestBody
    @Test
    void controllerCreateNewMenuWith_MockMvcServletRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/menu/createNewMenu")
                .contentType(MediaType.APPLICATION_JSON)
                .param("labelMenu", request.getParameterValues("labelMenu"))
                .param("version", request.getParameterValues("version"))
                .param("active", request.getParameterValues("active")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.labelMenu", is("Menu Servlet")));

        var menu = menuRepository.findByLabelMenu("Menu Servlet");

        assertNotNull(menu);
        System.out.println(menu);
    }

    @Test
    void controllerGetAllMenu() throws Exception{
        Menu menu = new Menu();
        menu.setLabelMenu("Test Menu");
        menu.setVersion("1.2.3");
        menu.setActive(true);

        entityManager.persist(menu);
        entityManager.flush();

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/menu/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        var menus = menuRepository.findAll();
        assertNotNull(menus);
    }

    @AfterEach
    void deleteMenu(){
        menuRepository.deleteAll();
    }

}