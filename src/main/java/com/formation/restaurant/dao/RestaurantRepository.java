package com.formation.restaurant.dao;

import com.formation.restaurant.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}
