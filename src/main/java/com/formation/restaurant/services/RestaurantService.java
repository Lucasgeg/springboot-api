package com.formation.restaurant.services;

import com.formation.restaurant.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    public List<Restaurant> findAll();

    public Restaurant findById(String id);

    public String create(Restaurant restaurant);


    public void update(String identifiant, Restaurant restaurant);

    void partialUpdate(String identifiant, Map<String, Object> updates);

    void deleteById(String identifiant);
}
