package com.formation.restaurant.services.impl;

import com.formation.restaurant.dao.RestaurantRepository;
import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll(){

        //Restaurant list

        List<Restaurant> liste = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(liste::add);
        return liste;

    }

    @Override
    public Restaurant findById(String id) {
        //on vérifie que l'id existe
        if (restaurantRepository.existsById(id)){
            return restaurantRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public String create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant).getId();
    }

    @Override
    public void update(String identifiant, Restaurant restaurant) {
        restaurant.setId(identifiant);
        restaurantRepository.save(restaurant);
    }

    @Override
    public void partialUpdate(String identifiant, Map<String, Object> updates) {
    Restaurant restoToUpdate = restaurantRepository.findById(identifiant).get();
    for(String key: updates.keySet()) {
        switch (key) {
            case "nom": {
                restoToUpdate.setNom((String) updates.get(key));
                break;
            }
            case "adresse": {
                restoToUpdate.setAdresse((String) updates.get(key));
                break;
            }
        }
    }
    restaurantRepository.save(restoToUpdate);
    }

    @Override
    public void deleteById(String identifiant) {
        restaurantRepository.deleteById(identifiant);
    }
}
