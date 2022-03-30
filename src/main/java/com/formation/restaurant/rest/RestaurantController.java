package com.formation.restaurant.rest;

import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.services.util.controllerCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restoService; //importation of the service
    //Get all restaurants
    @GetMapping
    public List<Restaurant> findAll(){
        return restoService.findAll();

    }
    //get one restaurant by Id
    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") String identifiant){
        Restaurant response = restoService.findById(identifiant);
        controllerCondition.checkFound(response);
        return response;
    }
    //Create a restaurant and sending Response
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public String create(@RequestBody Restaurant restaurant){
        return restoService.create(restaurant);
    }



    //Update Restaurant global information by finding his Id and his new body request
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") String identifiant, @RequestBody Restaurant restaurant) {
        controllerCondition.checkFound(restoService.findById(identifiant));
        restoService.update(identifiant, restaurant);
    }

    //Update partially a Restaurant information by finding Id and modify with a switch
    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String identifiant, @RequestBody Map<String, Object> updates) {

        controllerCondition.checkFound(restoService.findById(identifiant));
        restoService.partialUpdate(identifiant, updates);
    }

    //Delete a restaurant by finding it with his id
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable("id") String identifiant){
        controllerCondition.checkFound(restoService.findById(identifiant));
        restoService.deleteById(identifiant);
    }
}
