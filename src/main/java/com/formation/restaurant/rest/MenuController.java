package com.formation.restaurant.rest;

import com.formation.restaurant.models.Menu;
import com.formation.restaurant.services.MenuService;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.services.util.controllerCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MenuController {
    @Autowired
    public MenuService menuService;
    @Autowired
    public RestaurantService restoService;

    @GetMapping("/restaurants/{idResto}/menus")
    public Set<Menu> findAllRestaurant(@PathVariable("idResto") String idRestaurant) {
        controllerCondition.checkFound(restoService.findById(idRestaurant));
        return menuService.findAllRestaurant(idRestaurant);
    }
    @GetMapping("/menu/{id}")
    public Menu findById(@PathVariable("id") String id){
        Menu response = menuService.findById(id);
        controllerCondition.checkFound(response);
        return menuService.findById(id);
    }
    @PostMapping("/restaurants/{idResto}/menus")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@PathVariable("idResto") String idRestaurant, @RequestBody Menu menu){
        controllerCondition.checkFound(restoService.findById(idRestaurant));
        return menuService.create(idRestaurant, menu);
    }
    @PutMapping("/menus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody Menu menu){
        controllerCondition.checkFound(menuService.findById(id));
        menuService.update(id, menu);
    }
    @PatchMapping("/menus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String id, @RequestBody Map<String, Object> updates ){
        controllerCondition.checkFound(menuService.findById(id));
        menuService.partialUpdate(id, updates);
    }
    @DeleteMapping("/restaurant/{idResto}/menus/{idMenu}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("idResto")String idRestaurant, @PathVariable("idMenu") String idMenu){
        controllerCondition.checkFound(restoService.findById(idRestaurant));
        controllerCondition.checkFound(menuService.findById(idMenu));
        menuService.deleteById(idRestaurant, idMenu);
    }
}
