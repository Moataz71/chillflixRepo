package com.molveno.molveno.restaurant.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientsController {

    @Autowired
    IngredientRepository ingredientRepository;


    @RequestMapping(value = "/get-ingredients",method = RequestMethod.GET)
    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    @RequestMapping(value = "/save-ingredients",method = RequestMethod.POST,consumes = "application/json")
    public void saveIngredients(@RequestBody Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }






}
