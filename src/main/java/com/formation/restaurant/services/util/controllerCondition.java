package com.formation.restaurant.services.util;

import com.formation.restaurant.exception.RessourceNotFoundException;

public final class controllerCondition {

    public static <T> T checkFound(T object){
        if(object==null){
            throw new RessourceNotFoundException();
        }
        return object;
    }
}
