package com.formation.restaurant.services;

import com.formation.restaurant.models.Menu;

import java.util.*;

public interface MenuService {
    public Set<Menu> findAllRestaurant(String idRestaurant);

    Menu findById(String id);

    String create(String idRestaurant, Menu menu);

    void update(String id, Menu menu);

    void partialUpdate(String id, Map<String,Object> updates);

    void deleteById(String idRestaurant, String idMenu);
}
