package com.molveno.molveno.restaurant.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    DishRepository dishRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    @RequestMapping(value = "/get-dish", method = RequestMethod.GET)
    public List<Dish> getDishes() {
        return dishRepository.findAll();
    }

    @RequestMapping(value = "/save-dish", method = RequestMethod.POST, consumes = "application/json")
    public void saveDish(@RequestBody Dish dish) {
        int i =dish.getIngredients().size()-1;
        while (i>=0){

            ingredientRepository.save(dish.getIngredients().get(i));
            i--;
        }
dishRepository.save(dish);
    }

}