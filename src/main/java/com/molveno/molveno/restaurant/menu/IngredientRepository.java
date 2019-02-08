package com.molveno.molveno.restaurant.menu;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
    List<Ingredient> findAll();
Ingredient findById(long id);


}
